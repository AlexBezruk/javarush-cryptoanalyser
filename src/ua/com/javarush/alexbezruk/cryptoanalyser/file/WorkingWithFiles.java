package ua.com.javarush.alexbezruk.cryptoanalyser.file;

import java.io.*;

public class WorkingWithFiles {
    public static char[] readingFile(File file) {
        int symbol;

        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             CharArrayWriter writer = new CharArrayWriter()) {
            while ((symbol = reader.read()) != -1) {
                writer.write(symbol);
            }
            return writer.toCharArray();
        }  catch (IOException e) {
            throw new FileIOException("Ошибка при чтении файла " + file, e);
        }
    }

    public static void writingFile(char[] charArray, File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(charArray);
        } catch (IOException e) {
            throw new FileIOException("Ошибка при записи файла " + file, e);
        }
    }
}
