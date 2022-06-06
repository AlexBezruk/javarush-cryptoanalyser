package ua.com.javarush.alexbezruk.cryptoanalyser.logic;

import ua.com.javarush.alexbezruk.cryptoanalyser.data.Alphabet;
import ua.com.javarush.alexbezruk.cryptoanalyser.data.Words;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Decryption {
    private static final String WORD_SEPARATOR_REGEX = "[^A-Za-zА-Яа-я]+";

    public static char[] performByKey(char[] originalCharArray, int key) {
        return Encryption.perform(originalCharArray, Alphabet.LENGTH - key);
    }

    public static char[] performBruteForce(char[] originalCharArray) {
        int key = searchKey(originalCharArray);

        return performByKey(originalCharArray, key);
    }

    public static char[] performStatisticalAnalysis(char[] originalCharArray) {
        int numberSymbol = searchNumberOfMostUsedSymbol(originalCharArray);
        int key = numberSymbol - Arrays.binarySearch(Alphabet.getSorted(), ' ');
        return performByKey(originalCharArray, key);
    }

    private static int searchNumberOfMostUsedSymbol(char[] originalCharArray) {
        int key = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (Character symbol : originalCharArray) {
            int indexLetter = Arrays.binarySearch(Alphabet.getSorted(), symbol);
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
                key = Arrays.binarySearch(Alphabet.getSorted(), entry.getKey());
            }
        }

        return key;
    }

    private static int searchKey(char[] originalCharArray) {
        int maxPoints = 0;
        int keyWithMaxPoints = 0;

        for (int i = 1; i < Alphabet.LENGTH; i++) {
            int points = 0;

            String text = new String(performByKey(originalCharArray, i));
            String[] words = text.split(WORD_SEPARATOR_REGEX);

            for (String word : words) {
                if (Arrays.binarySearch(Words.getSortedMostUsedWords(), word.toLowerCase()) >= 0) {
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
