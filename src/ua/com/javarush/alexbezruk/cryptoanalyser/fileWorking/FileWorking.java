package ua.com.javarush.alexbezruk.cryptoanalyser.fileWorking;

import ua.com.javarush.alexbezruk.cryptoanalyser.Alphabet;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Arrays;

public class FileWorking {
    public static void writeFromReaderToWriter(Reader reader, Writer writer, int key) {
        int symbol;
        try {
            while ((symbol = reader.read()) != -1) {
                int indexLetter = Arrays.binarySearch(Alphabet.ALPHABET, (char) symbol);
                if (indexLetter < 0) {
                    writer.write(symbol);
                    continue;
                }
                int newIndexLetter = (indexLetter + key) % Alphabet.ALPHABET.length;
                writer.write(Alphabet.ALPHABET[newIndexLetter]);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при при работе с файлами " + e.getMessage());
        }
    }
}
