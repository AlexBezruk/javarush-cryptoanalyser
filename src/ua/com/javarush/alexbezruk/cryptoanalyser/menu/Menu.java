package ua.com.javarush.alexbezruk.cryptoanalyser.menu;

import ua.com.javarush.alexbezruk.cryptoanalyser.Alphabet;
import ua.com.javarush.alexbezruk.cryptoanalyser.logic.DecryptionBruteForce;
import ua.com.javarush.alexbezruk.cryptoanalyser.logic.DecryptionKey;
import ua.com.javarush.alexbezruk.cryptoanalyser.logic.DecryptionStatisticalAnalysis;
import ua.com.javarush.alexbezruk.cryptoanalyser.logic.Encryption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Arrays;

public class Menu {
    private static final String MENU = """
            Введите номер требуемой операции:
            1 - для шифровки текста
            2 - для расшифровки текста с помощью ключа
            3 - для расшифровки текста с помощью brute force
            4 - для расшифровки текста с помощью статистического анализа
            0 - для выхода из программы
            """;
    private static final String MENU1 = """
            Вы выбрали шифровку текста. 
            Пожалуйста введите через пробел адрес файла с оригинальным текстом, адрес файла, в который нужно записать зашифрованный текст, и сдвиг по алфавиту.
            Например, original_file.txt encryption_file.txt 2
            """;
    private static final String MENU2 = """
            Вы выбрали расшифровку текста с помощью ключа. 
            Пожалуйста введите через пробел адрес зашифрованного файла, адрес файла, в который нужно записать расшифрованный текст и сдвиг по алфавиту, который использовался при шифровании.
            Например, encryption_file.txt decrypted_file.txt 2
            """;
    private static final String MENU3 = """
            Вы выбрали расшифровку текста с помощью brute force. 
            Пожалуйста введите через пробел адрес зашифрованного файла, адрес файла, в который нужно записать расшифрованный текст
            Например, encryption_file.txt decrypted_file.txt
            """;
    private static final String MENU4 = """
            Вы выбрали расшифровку текста с помощью статистического анализа. 
            Пожалуйста введите через пробел адрес зашифрованного файла, адрес файла, в который нужно записать расшифрованный текст
            Например, encryption_file.txt decrypted_file.txt
            """;
    private static final String DEFAULT_MENU = "Введены данные неверного формата либо диапазона. Введите цифру от 0 до 4";
    private static final String SEPARATOR = " ";
    private static final String IO_EXCEPTION = "Возникла ошибка при чтении данных с консоли";
    private static final String INVALID_DATA_FORMAT = "Неверный формат данных";


    public static void startMenu() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number;

        do {
            System.out.println(MENU);
            number = 1;
            String[] request;

            try {
                number = Integer.parseInt(reader.readLine());
                switch (number) {
                    case 1 -> {
                        System.out.println(MENU1);

                        request = reader.readLine().split(SEPARATOR);
                        if (request.length != 3) {
                            System.err.println(INVALID_DATA_FORMAT);
                            continue;
                        }

                        String originalFile = request[0];
                        String encryptionFile = request[1];
                        int key = Integer.parseInt(request[2]);

                        Encryption.encryption(originalFile, encryptionFile, key);
                    }
                    case 2 -> {
                        System.out.println(MENU2);

                        request = reader.readLine().split(SEPARATOR);
                        if (request.length != 3) {
                            System.err.println(INVALID_DATA_FORMAT);
                            continue;
                        }

                        String encryptionFile = request[0];
                        String decryptionFile = request[1];
                        int key = Integer.parseInt(request[2]);

                        DecryptionKey.decryptionKey(encryptionFile, decryptionFile, key);
                    }
                    case 3 -> {
                        System.out.println(MENU3);

                        request = reader.readLine().split(SEPARATOR);
                        if (request.length != 2) {
                            System.err.println(INVALID_DATA_FORMAT);
                            continue;
                        }

                        Path encryptionFile = Path.of(request[0]);
                        Path decryptionFile = Path.of(request[1]);

                        DecryptionBruteForce.decryptionBruteForce(encryptionFile, decryptionFile);
                    }
                    case 4 -> {
                        System.out.println(MENU4);

                        request = reader.readLine().split(SEPARATOR);
                        if (request.length != 2) {
                            System.err.println(INVALID_DATA_FORMAT);
                            continue;
                        }

                        Path encryptionFile = Path.of(request[0]);
                        Path decryptionFile = Path.of(request[1]);

                        DecryptionStatisticalAnalysis.decryptionStatisticalAnalysis(encryptionFile, decryptionFile);
                    }
                    case 0 -> {
                        continue;
                    }
                    default -> {
                        System.out.println(DEFAULT_MENU);
                    }
                }
            } catch (IOException e) {
                throw new IllegalArgumentException(IO_EXCEPTION);
            } catch (NumberFormatException e) {
                System.out.println(DEFAULT_MENU);
            }
        } while (number != 0);
    }
}
