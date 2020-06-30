package by.kharitonov.day5.service.impl;

import by.kharitonov.day5.service.TextProcessing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTextProcessingImpl implements TextProcessing {
    private static final String REGEX_PART_BEFORE_INDEX = "\\b[\\S]{";
    private static final String REGEX_PART_AFTER_INDEX = ",}\\b";
    private static final String REGEX_WORD_BEFORE_LENGTH = "\\b[à-ÿÀ-ß¸¨\\w]{";
    private static final String REGEX_WORD_AFTER_LENGTH = "}\\b";
    private static final String REGEX_NOT_SPACE_LETTER =
            "([^à-ÿÀ-ßa-zA-Z¸¨\\s]+)(\\r\\n)*";
    private static final String REGEX_CONSONANT_WORD_BEFORE_LENGTH =
            "\\b[á-ùÁ-Ù\\w&&[^\\då¸èîóûÅ¨ÈÎÓÛaeiouAEIOU]][\\S]{";

    @Override
    public String replaceCharInWord(String text, int index,
                                    char charReplacement) {
        String regEx = REGEX_PART_BEFORE_INDEX + index + REGEX_PART_AFTER_INDEX;
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String temp = "" + charReplacement;
            int start = matcher.start() + index - 1;
            int end = start + 1;
            text = replace(text, start, end, temp);
        }
        return text;
    }

    private String replace(String text, int start, int end,
                           String replacement) {
        String head = text.substring(0, start);
        String tail = text.substring(end);
        return head + replacement + tail;
    }

    @Override
    public String replaceOneWithAnother(String text, String target,
                                        String replacement) {
        Pattern pattern = Pattern.compile(target);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            text = replace(text, matcher.start(), matcher.end(), replacement);
        }
        return text;
    }

    @Override
    public String replaceWordsToSubstring(String text, int wordLength,
                                          String substring) {
        String regEx = REGEX_WORD_BEFORE_LENGTH + wordLength +
                REGEX_WORD_AFTER_LENGTH;
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);
        int delta = 0;
        while (matcher.find()) {
            int start = matcher.start() + delta;
            int end = matcher.end() + delta;
            text = replace(text, start, end, substring);
            delta += substring.length() - wordLength;
        }
        return text;
    }

    @Override
    public String deleteAllNotSpaceOrLetter(String text) {
        String regEx = REGEX_NOT_SPACE_LETTER;
        Pattern pattern = Pattern.compile(regEx, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(text);
        int start;
        int end;
        int delta = 0;
        while (matcher.find()) {
            start = matcher.start() + delta;
            end = matcher.end() + delta;
            text = replace(text, start, end, " ");
            delta += (matcher.start() - matcher.end() + 1);
        }
        return text;
    }

    @Override
    public String deleteConsonantWords(String text, int wordLength) {
        String regEx = REGEX_CONSONANT_WORD_BEFORE_LENGTH + (wordLength - 1) +
                REGEX_WORD_AFTER_LENGTH;
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);
        int delta = 0;
        while (matcher.find()) {
            int start = matcher.start() + delta;
            int end = matcher.end() + delta;
            text = replace(text, start, end, "");
            delta -= wordLength;
        }
        return text;
    }
}
