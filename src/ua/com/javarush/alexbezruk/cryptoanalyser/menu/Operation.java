package ua.com.javarush.alexbezruk.cryptoanalyser.menu;

public enum Operation {
    encryption(1),
    decryptionKey(2),
    decryptionBruteForce(3),
    decryptionStatisticalAnalysis(4);

    int number;

    Operation(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
