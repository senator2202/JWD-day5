package by.kharitonov.day5.service.impl;

import by.kharitonov.day5.service.TextProcessing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTextProcessingImpl implements TextProcessing {
    private static final String REGEX_SPLIT_WORDS =
            "\\s*(\\s|,|!|\\.|;|:|\\?)\\s*";
    private static final String WORD_BOUNDARY = "\\b";
    private static final String REGEX_NOT_TARGET_BEFORE = "[^(";
    private static final String REGEX_NOT_TARGET_AFTER = ")]";
    private static final String REGEX_SPLIT_NOT_SPACE_LETTER;

    static {
        String ls = System.getProperty("line.separator");
        REGEX_SPLIT_NOT_SPACE_LETTER = "[�-��-�a-zA-Z��\\s&&[^" + ls + "]]+";
    }

    public String replaceCharInWord(String text, int index,
                                    char charReplacement) {
        String[] result = {text};
        Arrays.stream(text.split(REGEX_SPLIT_WORDS))
                .filter(word -> word.length() >= index).distinct()
                .collect(Collectors.toMap(word -> WORD_BOUNDARY + word + WORD_BOUNDARY, word ->
                        word.substring(0, index - 1) + charReplacement + word.substring(index)))
                .forEach((k, v) -> result[0] = result[0].replaceAll(k, v));
        return result[0];
    }

    @Override
    public String replaceOneWithAnother(String text, String target,
                                        String replacement) {
        String[] result = {text};
        Arrays.stream(text.split(REGEX_NOT_TARGET_BEFORE + target + REGEX_NOT_TARGET_AFTER))
                .filter(word -> word.contains(target)).distinct()
                .collect(Collectors.toMap(word -> word, word -> replacement))
                .forEach((k, v) -> result[0] = result[0].replaceAll(k, v));
        return result[0];
    }

    @Override
    public String replaceWordsToSubstring(String text, int wordLength,
                                          String substring) {
        String[] result = {text};
        Arrays.stream(text.split(REGEX_SPLIT_WORDS))
                .filter(word -> word.length() == wordLength).distinct()
                .collect(Collectors.toMap(word -> WORD_BOUNDARY + word + WORD_BOUNDARY,
                        word -> substring))
                .forEach((k, v) -> result[0] = result[0].replaceAll(k, v));
        return result[0];
    }

    @Override
    public String deleteAllNotSpaceOrLetter(String text) {
        String[] result = {text};
        Arrays.stream(text.split(REGEX_SPLIT_NOT_SPACE_LETTER))
                .filter(symbals -> !symbals.isEmpty()).distinct()
                .collect(Collectors.toMap(symbals -> symbals, symbals -> " "))
                .forEach((k, v) -> result[0] = result[0].replaceAll(ignoreMeta(k), v));
        return result[0];
    }

    private String ignoreMeta(String data) {
        return "\\Q" + data + "\\E";
    }

    @Override
    public String deleteConsonantWords(String text, int wordLength) {
        String[] result = {text};
        Arrays.stream(text.split(REGEX_SPLIT_WORDS))
                .filter(word -> word.length() == wordLength && startsConsonant(word)).distinct()
                .collect(Collectors.toMap(symbals -> symbals, symbals -> ""))
                .forEach((k, v) -> result[0] = result[0].replaceAll(k, v));
        return result[0];
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
