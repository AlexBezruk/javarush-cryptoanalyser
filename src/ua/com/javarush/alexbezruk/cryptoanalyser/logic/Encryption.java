package ua.com.javarush.alexbezruk.cryptoanalyser.logic;

import ua.com.javarush.alexbezruk.cryptoanalyser.fileWorking.FileWorking;

import java.io.*;

public class Encryption {

    public static void encryption(String originalFile, String encryptionFile, int key) {
        try (BufferedReader reader = new BufferedReader(new FileReader(originalFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(encryptionFile))) {
            FileWorking.writeFromReaderToWriter(reader, writer, key);
        } catch (FileNotFoundException e) {
            System.err.println("Файл для чтения не найден" + originalFile);
        } catch (IOException e) {
            System.err.println("Ошибка при записи файла " + encryptionFile);
        }
    }
}
