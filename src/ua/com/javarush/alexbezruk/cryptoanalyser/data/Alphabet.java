package ua.com.javarush.alexbezruk.cryptoanalyser.data;

import java.util.Arrays;

public class Alphabet {
    private static final char[] ALPHABET = ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ" +
            ".,«»:;!?-() ").toCharArray();
    public static final int LENGTH = ALPHABET.clone().length;

    public static char[] getSorted() {
        Arrays.sort(ALPHABET.clone());
        return ALPHABET;
    }
}
