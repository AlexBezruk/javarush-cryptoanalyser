package ua.com.javarush.alexbezruk.cryptoanalyser.logic;

import ua.com.javarush.alexbezruk.cryptoanalyser.data.Alphabet;

import java.util.Arrays;

public class Encryption {
    public static char[] encryption(char[] originalCharArray, int key) {
        char[] modifiedCharArray = new char[originalCharArray.length];

        for (int i = 0; i < originalCharArray.length; i++) {
            int indexLetter = Arrays.binarySearch(Alphabet.getSortedAlphabet(), originalCharArray[i]);
            if (indexLetter < 0) {
                modifiedCharArray[i] = originalCharArray[i];
                continue;
            }
            int newIndexLetter = (indexLetter + key) % Alphabet.getAlphabetLength();
            modifiedCharArray[i] = Alphabet.getSortedAlphabet()[newIndexLetter];
        }
        return modifiedCharArray;
    }
}
