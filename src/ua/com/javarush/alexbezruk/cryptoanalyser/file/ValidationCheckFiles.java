package ua.com.javarush.alexbezruk.cryptoanalyser.file;

import java.io.File;

public class ValidationCheckFiles {
    public static boolean isExists(File file) {
        if (!file.exists()) {
            System.err.println(file + " не существует.");
            return false;
        }
        return true;
    }

    public static boolean isFile(File file) {
        if (!file.isFile()) {
            System.err.println(file + " - это не файл.");
            return false;
        }
        return true;
    }

    public static boolean isCanRead(File file) {
        if (!file.canRead()) {
            System.err.println(file + " не может быть прочитан");
            return false;
        }
        return true;
    }

    public static boolean isDirectory(File file) {
        if (file.isDirectory()) {
            System.err.println(file + " это не файл, а директория");
            return true;
        }
        return false;
    }
}
