package ua.com.javarush.alexbezruk.cryptoanalyser.logic;

import ua.com.javarush.alexbezruk.cryptoanalyser.Alphabet;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Decryption {
    public static char[] decryptionKey(char[] originalCharArray, int key) {
        return Encryption.encryption(originalCharArray, Alphabet.getSortedAlphabet().length - key);
    }

    public static char[] decryptionBruteForce(char[] originalCharArray) {
        int key = searchKey(originalCharArray);

        return decryptionKey(originalCharArray, key);
    }

    public static char[] decryptionStatisticalAnalysis(char[] originalCharArray) {
        int numberSymbol = searchNumberOfMostUsedSymbol(originalCharArray);
        int key = numberSymbol - Arrays.binarySearch(Alphabet.getSortedAlphabet(), ' ');
        return decryptionKey(originalCharArray, key);
    }

    private static int searchNumberOfMostUsedSymbol(char[] originalCharArray) {
        int key = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (Character symbol : originalCharArray) {
            int indexLetter = Arrays.binarySearch(Alphabet.getSortedAlphabet(), symbol);
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
                key = Arrays.binarySearch(Alphabet.getSortedAlphabet(), entry.getKey());
            }
        }

        return key;
    }

    private static int searchKey(char[] originalCharArray) {
        int points;
        int maxPoints = 0;
        int keyWithMaxPoints = 0;

        for (int i = 1; i < Alphabet.getSortedAlphabet().length; i++) {
            points = 0;

            String text = new String(decryptionKey(originalCharArray, i));
            String[] words = text.split("[^A-Za-zА-Яа-я]+");
            Arrays.sort(Alphabet.getMostUsedWords());

            for (String word : words) {
                if (Arrays.binarySearch(Alphabet.getMostUsedWords(), word.toLowerCase()) >= 0) {
                    points += word.length();
                }
            }

            if (points > maxPoints) {
                maxPoints = points;
                keyWithMaxPoints = i;
            }
        }

        return keyWithMaxPoints;
    }
}
