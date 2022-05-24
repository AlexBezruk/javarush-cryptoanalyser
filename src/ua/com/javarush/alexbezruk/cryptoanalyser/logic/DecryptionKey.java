package ua.com.javarush.alexbezruk.cryptoanalyser.logic;

import ua.com.javarush.alexbezruk.cryptoanalyser.Alphabet;

public class DecryptionKey {

    public static void decryptionKey(String encryptionFile, String decryptedFile, int key) {
        Encryption.encryption(encryptionFile, decryptedFile, Alphabet.ALPHABET.length - key);
    }
}
