package ua.com.javarush.alexbezruk.cryptoanalyser;

import ua.com.javarush.alexbezruk.cryptoanalyser.file.FileIOException;
import ua.com.javarush.alexbezruk.cryptoanalyser.menu.Dialog;

public class Main {
    public static void main(String[] args) {
        try {
            Dialog.run();
        } catch (FileIOException e) {
            System.err.println(e.getMessage());
        }
    }
}
