package by.kharitonov.day5.service;

import java.util.ArrayList;
import java.util.List;

public class StringHandlingService {
    private static final String REGEX_SPLIT_WORDS = "\\s*(\\s|,|-|!|\\.)\\s*";
    private static final String REGEX_SPLIT_NOT_SPACE_LETTER =
            "[à-ÿÀ-ßa-zA-Z\\s]+";

    /*index starts from 1*/
    public String replaceCharInWord(String text, int index,
                                    char charReplacement) {
        String[] words = text.split(REGEX_SPLIT_WORDS);
        for (String word : words) {
            if (word.length() >= index) {
                StringBuilder sb = new StringBuilder(word);
                sb.setCharAt(index - 1, charReplacement);
                text = text.replaceFirst(word, sb.toString());
            }
        }
        return text;
    }

    public String changePAToPO(String text) {
        return text.replaceAll("ÐÀ", "ÐÎ");
    }

    public String replaceWordsToSubstring(String text, int wordLength,
                                          String substring) {
        String[] words = text.split(REGEX_SPLIT_WORDS);
        for (String word : words) {
            if (word.length() == wordLength) {
                text = text.replaceAll(word, substring);
            }
        }
        return text;
    }

    public String deleteAllNotSpaceOrLetter(String text) {
        String[] targets = text.split(REGEX_SPLIT_NOT_SPACE_LETTER);
        for (String target : targets) {
            text = text.replaceFirst(target, " ");
        }
        return text;
    }

    public String deleteConsonantWords(String text, int wordLength) {
        String[] words = text.split(REGEX_SPLIT_WORDS);
        for (String word : words) {
            if (word.length() == wordLength && startsConsonant(word)) {
                text = text.replaceFirst(word, "");
            }
        }
        return text;
    }

    private boolean startsConsonant(String word) {
        StringBuilder sb = new StringBuilder(word.toLowerCase());
        Character ch = sb.charAt(0);
        return consonantList().indexOf(ch) != -1;
    }

    private List<Character> consonantList() {
        List<Character> list = new ArrayList<>();
        list.add('á');
        list.add('â');
        list.add('ã');
        list.add('ä');
        list.add('æ');
        list.add('ç');
        list.add('é');
        list.add('ê');
        list.add('ë');
        list.add('ì');
        list.add('í');
        list.add('ï');
        list.add('ð');
        list.add('ñ');
        list.add('ò');
        list.add('ô');
        list.add('õ');
        list.add('ö');
        list.add('÷');
        list.add('ø');
        list.add('ù');
        list.add('b');
        list.add('c');
        list.add('d');
        list.add('f');
        list.add('g');
        list.add('h');
        list.add('j');
        list.add('k');
        list.add('l');
        list.add('m');
        list.add('p');
        list.add('q');
        list.add('r');
        list.add('s');
        list.add('t');
        list.add('v');
        list.add('w');
        list.add('x');
        list.add('z');
        return list;
    }
}
