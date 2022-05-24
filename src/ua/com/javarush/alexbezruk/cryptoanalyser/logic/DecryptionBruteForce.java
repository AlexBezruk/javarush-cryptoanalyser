package ua.com.javarush.alexbezruk.cryptoanalyser.logic;

import ua.com.javarush.alexbezruk.cryptoanalyser.Alphabet;
import ua.com.javarush.alexbezruk.cryptoanalyser.fileWorking.FileWorking;

import java.io.*;
import java.util.Arrays;

public class DecryptionBruteForce {

    public static void decryptionBruteForce(String encryptionFile, String decryptedFile) {
        int points;
        int maxPoints = 0;
        int keyWithMaxPoints = 0;

        for (int i = 0; i < Alphabet.ALPHABET.length; i++) {
            try (BufferedReader reader = new BufferedReader(new FileReader(encryptionFile));
                 CharArrayWriter writer = new CharArrayWriter()) {
                points = 0;
                FileWorking.writeFromReaderToWriter(reader, writer, i);
                String[] array = writer.toString().split("(?U)\\W+");
                Arrays.sort(Alphabet.MOST_USED_WORDS);
                for (String word : array) {
                    if (Arrays.binarySearch(Alphabet.MOST_USED_WORDS, word) >= 0) {
                        points += word.length();
                    }
                }
                if (points > maxPoints) {
                    maxPoints = points;
                    keyWithMaxPoints = i;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Encryption.encryption(encryptionFile, decryptedFile, keyWithMaxPoints);
    }
}
