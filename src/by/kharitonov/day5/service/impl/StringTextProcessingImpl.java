package by.kharitonov.day5.service.impl;

import by.kharitonov.day5.service.TextProcessing;

import java.util.ArrayList;
import java.util.List;

public class StringTextProcessingImpl implements TextProcessing {
    private static final String REGEX_SPLIT_WORDS;
    private static final String REGEX_SPLIT_NOT_SPACE_LETTER;

    static {
        String ls = System.getProperty("line.separator");
        REGEX_SPLIT_NOT_SPACE_LETTER = "[�-��-�a-zA-Z��\\s&&[^" + ls + "]]+";
        REGEX_SPLIT_WORDS = "\\s*(\\s|,|!|\\.)\\s*";
    }

    /*index starts from 1*/
    @Override
    public String replaceCharInWord(String text, int index,
                                    char charReplacement) {
        String[] words = text.split(REGEX_SPLIT_WORDS);
        for (String word : words) {
            if (word.length() >= index) {
                StringBuilder sb = new StringBuilder(word);
                String regex = "\\b" + word + "\\b";
                sb.setCharAt(index - 1, charReplacement);
                text = text.replaceFirst(regex, sb.toString());
            }
        }
        return text;
    }

    @Override
    public String replaceOneWithAnother(String text, String target,
                                        String replacement) {
        return text.replace(target, replacement);
    }

    @Override
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

    @Override
    public String deleteAllNotSpaceOrLetter(String text) {
        String regEx = REGEX_SPLIT_NOT_SPACE_LETTER;
        String[] targets = text.split(regEx);
        for (String target : targets) {
            if (target.isEmpty()) {
                continue;
            }
            target = handleMeta(target);
            text = text.replaceFirst(target, " ");
        }
        return text;
    }

    private String handleMeta(String data) {
        StringBuilder sb = new StringBuilder(data);
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (isMeta(ch)) {
                sb.insert(i++, '\\');
            }
        }
        return sb.toString();
    }

    private boolean isMeta(char ch) {
        return getMetaSymbols().indexOf(ch) != -1;
    }

    private List<Character> getMetaSymbols() {
        List<Character> list = new ArrayList<>();
        list.add('.');
        list.add('$');
        list.add('\\');
        list.add('*');
        list.add('+');
        list.add('?');
        list.add('^');
        list.add('|');
        return list;
    }

    @Override
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
        list.add('�');
        list.add('�');
        list.add('�');
        list.add('�');
        list.add('�');
        list.add('�');
        list.add('�');
        list.add('�');
        list.add('�');
        list.add('�');
        list.add('�');
        list.add('�');
        list.add('�');
        list.add('�');
        list.add('�');
        list.add('�');
        list.add('�');
        list.add('�');
        list.add('�');
        list.add('�');
        list.add('�');
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
