package ua.com.javarush.alexbezruk.cryptoanalyser.menu;

public enum MenuItems {
    START_MENU("""
            Введите номер требуемой операции:
            1 - для шифровки текста
            2 - для расшифровки текста с помощью ключа
            3 - для расшифровки текста с помощью brute force
            4 - для расшифровки текста с помощью статистического анализа
            0 - для выхода из программы
            """),

    ENCRYPTION("Вы выбрали шифровку текста."),
    DECRYPTION_BY_KEY("Вы выбрали расшифровку текста с помощью ключа."),
    DECRYPTION_BRUTE_FORCE("Вы выбрали расшифровку текста с помощью brute force"),
    DECRYPTION_STATISTICAL_ANALYSIS("Вы выбрали расшифровку текста с помощью статистического анализа."),

    FILE_TO_ENCRYPT("Введите адрес файла, который нужно зашифровать"),
    FILE_TO_DECRYPT("Введите адрес файла, который нужно расшифровать"),

    ENCRYPTED_FILE("Введите адрес файла, в который нужно записать зашифрованный текст"),
    DECRYPTED_FILE("Введите адрес файла, в который нужно записать расшифрованный текст"),

    ENCRYPTION_KEY("Введите сдвиг по алфавиту (ключ Шифра Цезаря)."),
    DECRYPTION_KEY("Введите сдвиг по алфавиту, который использовался при шифровании (ключ).");

    String menuCommand;

    MenuItems(String menu) {
        this.menuCommand = menu;
    }

    public String getMenuCommand() {
        return menuCommand;
    }
}
