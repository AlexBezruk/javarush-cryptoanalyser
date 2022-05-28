package ua.com.javarush.alexbezruk.cryptoanalyser;

public class Alphabet {
    private static final char[] SORTED_ALPHABET = {' ', '!', '"', '\'', ',', '.', ':', '?','«', '»',
            'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и','к', 'л', 'м', 'н', 'о', 'п', 'р',
            'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я'};


    private static final String[] MOST_USED_WORDS = {"и", "в", "не", "на", "я", "быть", "он", "с", "что", "а", "по",
            "это", "она", "этот", "к", "но", "они", "мы", "как", "из", "у", "который", "то", "за", "свой", "что",
            "весь", "год", "от", "так", "о", "для", "ты", "же", "все", "тот", "мочь", "вы", "человек", "такой"};

    public static char[] getSortedAlphabet() {
        return SORTED_ALPHABET;
    }

    public static String[] getMostUsedWords() {
        return MOST_USED_WORDS;
    }

    public static int getAlphabetLength() {
        return SORTED_ALPHABET.length;
    }
}
