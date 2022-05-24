package ua.com.javarush.alexbezruk.cryptoanalyser.logic;

import ua.com.javarush.alexbezruk.cryptoanalyser.Alphabet;
import ua.com.javarush.alexbezruk.cryptoanalyser.fileWorking.FileWorking;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DecryptionStatisticalAnalysis {

    public static void decryptionStatisticalAnalysis(String encryptionFile, String decryptedFile) {
        int key = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(encryptionFile));
             CharArrayWriter writer = new CharArrayWriter()) {
            FileWorking.writeFromReaderToWriter(reader, writer, 0);
            Map<Character, Integer> map = new HashMap<>();
            for (Character symbol : writer.toCharArray()) {
                int indexLetter = Arrays.binarySearch(Alphabet.ALPHABET, symbol);
                if (indexLetter >= 0) {
                    if (map.containsKey(symbol)) {
                        map.put(symbol, map.get(symbol) + 1);
                    } else {
                        map.put(symbol, 1);
                    }
                }
            }
            int maxValueInMap = Collections.max(map.values());
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() == maxValueInMap) {
                    key = Arrays.binarySearch(Alphabet.ALPHABET, entry.getKey());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Encryption.encryption(encryptionFile, decryptedFile, Alphabet.ALPHABET.length - key);
    }
}
