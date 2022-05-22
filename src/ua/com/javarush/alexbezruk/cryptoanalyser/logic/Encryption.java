package ua.com.javarush.alexbezruk.cryptoanalyser.logic;

import ua.com.javarush.alexbezruk.cryptoanalyser.Alphabet;

import java.io.*;
import java.util.Arrays;

public class Encryption {
    public static void encryption(String originalFile, String encryptionFile, int key) {
        StringBuilder builder;

        try (BufferedReader reader = new BufferedReader(new FileReader(originalFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(encryptionFile))) {
            int symbol;
            while ((symbol = reader.read()) != -1) {
                int indexLetter = Arrays.binarySearch(Alphabet.ALPHABET, (char) symbol);
                if (indexLetter < 0) {
                    writer.write(symbol);
                    continue;
                }
                int newIndexLetter = (indexLetter + key) % Alphabet.ALPHABET.length;
                writer.write(Alphabet.ALPHABET[newIndexLetter]);
            }
            System.out.println("Запись файла завершена");
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла " + originalFile);;
        }
    }
}
