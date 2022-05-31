package ua.com.javarush.alexbezruk.cryptoanalyser.menu;

import ua.com.javarush.alexbezruk.cryptoanalyser.data.Alphabet;
import ua.com.javarush.alexbezruk.cryptoanalyser.file.FileIOException;
import ua.com.javarush.alexbezruk.cryptoanalyser.file.ValidationCheckFiles;
import ua.com.javarush.alexbezruk.cryptoanalyser.file.WorkingWithFiles;
import ua.com.javarush.alexbezruk.cryptoanalyser.logic.Decryption;
import ua.com.javarush.alexbezruk.cryptoanalyser.logic.Encryption;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dialog {
    private static final String INVALID_FORMAT_OR_RANGE = "Введены данные неверного формата либо диапазона.";
    private static final String FROM_0_TO_4 = " Введите цифру от 0 до 4";
    private static final String ENCRYPTION_RANGE = " Ключ должен быть от 1 до " + (Alphabet.LENGTH - 1);
    private static final String IO_EXCEPTION = "Ошибка при чтении данных с консоли. ";

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int number;
    private static int key;
    private static File fileInput;
    private static File fileOutput;

    public static void run() {
        System.out.println(MenuItems.values()[0].getMenuCommand());

        runStartMenu();

        System.out.println(MenuItems.values()[number].getMenuCommand());

        fileInput = enteringFileInput();
        fileOutput = enteringFileOutput();
        if (number == 1 || number == 2) {
            key = enteringKey();
        }

        char[] inputText = WorkingWithFiles.readingFile(fileInput);
        char[] outputText = new char[inputText.length];

        switch (number) {
            case 1 -> outputText = Encryption.encryption(inputText, key);
            case 2 -> outputText = Decryption.decryptionKey(inputText, key);
            case 3 -> outputText = Decryption.decryptionBruteForce(inputText);
            case 4 -> outputText = Decryption.decryptionStatisticalAnalysis(inputText);
        }

        WorkingWithFiles.writingFile(outputText, fileOutput);
    }

    private static void runStartMenu() {
        try {
            number = Integer.parseInt(reader.readLine());
            if (number < 0 || number > 4) {
                throw new NumberFormatException();
            }
            if (number == 0) {
                System.exit(0);
            }
        } catch (NumberFormatException e) {
            System.err.println(INVALID_FORMAT_OR_RANGE + FROM_0_TO_4);
            runStartMenu();
        } catch (IOException e) {
            throw new RuntimeException(IO_EXCEPTION + e.getMessage());
        }
    }

    private static File enteringFileInput() {
        while (fileInput == null) {
            if (number == 1) {
                System.out.println(MenuItems.values()[5].getMenuCommand());
            } else {
                System.out.println(MenuItems.values()[6].getMenuCommand());
            }

            try {
                fileInput = new File(reader.readLine());
            } catch (IOException e) {
                throw new FileIOException(IO_EXCEPTION, e);
            }

            if (!ValidationCheckFiles.isExists(fileInput) || !ValidationCheckFiles.isFile(fileInput)
                    || !ValidationCheckFiles.isCanRead(fileInput) || ValidationCheckFiles.isDirectory(fileInput)) {
                fileInput = null;
            }
        }

        return fileInput;
    }

    private static File enteringFileOutput() {
        while (fileOutput == null) {
            if (number == 1) {
                System.out.println(MenuItems.values()[7].getMenuCommand());
            } else {
                System.out.println(MenuItems.values()[8].getMenuCommand());
            }

            try {
                fileOutput = new File(reader.readLine());
            } catch (IOException e) {
                throw new FileIOException(IO_EXCEPTION, e);
            }

            if (!fileOutput.exists()) {
                try {
                    fileOutput.createNewFile();
                } catch (IOException e) {
                    System.err.println("Файл не может быть создан");
                    fileOutput = null;
                }
            }

            if (fileOutput != null &&
                    (!ValidationCheckFiles.isFile(fileOutput) || ValidationCheckFiles.isDirectory(fileOutput))) {
                fileOutput = null;
            }
        }

        return fileOutput;
    }

    private static int enteringKey() {
        if (number == 1) {
            System.out.println(MenuItems.values()[9].getMenuCommand() + ENCRYPTION_RANGE);
        }
        if (number == 2) {
            System.out.println(MenuItems.values()[10].getMenuCommand() + ENCRYPTION_RANGE);
        }

        try {
            key = Integer.parseInt(reader.readLine());
            if (number <= 0 || number >= Alphabet.LENGTH - 1) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.err.println(INVALID_FORMAT_OR_RANGE + ENCRYPTION_RANGE);
            enteringKey();
        } catch (IOException e) {
            throw new FileIOException(IO_EXCEPTION, e);
        }

        return key;
    }
}
