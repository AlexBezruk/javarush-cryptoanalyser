package ua.com.javarush.alexbezruk.cryptoanalyser.data;

import java.util.Arrays;

public class Words {
    private static final String[] MOST_USED_WORDS = ("as i his that he was for on are with they be at one have this " +
            "from by hot word but what some is it you or had the of to and a in we an out other were which do their " +
            "time if will how said an each tell does set three want air well also play small end put home read hand " +
            "port large spell add even land here must big high such follow act why ask men change went light kind " +
            "off need house picture try us again animal point mother world near build self earth father" +
            " отец и в не на я быть он с что а по это она этот к но они мы как из у который то за свой что весь год " +
            "от так о для ты же все тот мочь вы человек такой его сказать только или ещё бы себя один как уже до " +
            "время если сам когда другой вот говорить наш мой знать стать при чтобы дело жизнь кто первый очень два " +
            "день её новый рука даже во со раз где там под можно ну какой после их работа без самый потом надо " +
            "хотеть ли слово идти большой должен место иметь ничто").split(" ");

    public static String[] getSortedMostUsedWords() {
        Arrays.sort(MOST_USED_WORDS);
        return MOST_USED_WORDS;
    }
}
