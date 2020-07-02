package by.kharitonov.day5.service.impl;

import by.kharitonov.day5.service.TextProcessing;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StreamTextProcessingImpl implements TextProcessing {
    private static final String REGEX_SPLIT_WORDS =
            "\\s*(\\s|,|!|\\.|;|:|\\?)\\s*";
    private static final String WORD_BOUNDARY = "\\b";

    public String replaceCharInWord(String text, int index,
                                    char charReplacement) {
        String[] s = {text};
        Arrays.stream(text.split(REGEX_SPLIT_WORDS))
                .filter(word -> word.length() >= index).distinct()
                .collect(Collectors.toMap(word -> WORD_BOUNDARY + word + WORD_BOUNDARY, word ->
                        word.substring(0, index - 1) + charReplacement + word.substring(index)))
                .forEach((k, v) -> s[0] = s[0].replaceAll(k, v));
        return s[0];
    }

    @Override
    public String replaceOneWithAnother(String text, String target,
                                        String replacement) {
        return null;
    }

    @Override
    public String replaceWordsToSubstring(String text, int wordLength,
                                          String substring) {
        return null;
    }

    @Override
    public String deleteAllNotSpaceOrLetter(String text) {
        return null;
    }

    @Override
    public String deleteConsonantWords(String text, int wordLength) {
        return null;
    }
}
