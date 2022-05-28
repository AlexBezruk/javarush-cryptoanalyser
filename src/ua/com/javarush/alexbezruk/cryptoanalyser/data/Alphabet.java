package ua.com.javarush.alexbezruk.cryptoanalyser.data;

import java.util.Arrays;

public class Alphabet {
    private static final char[] ALPHABET = ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ" +
            ".,«»:;!?-() ").toCharArray();

    public static char[] getSortedAlphabet() {
        Arrays.sort(ALPHABET);
        return ALPHABET;
    }

    public static int getAlphabetLength() {
        return ALPHABET.length;
    }
}
