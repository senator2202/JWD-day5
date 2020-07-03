package by.kharitonov.day5.service.impl;

import by.kharitonov.day5.service.TextProcessing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTextProcessingImpl implements TextProcessing {
    private static final String REGEX_NOT_SPACE_LETTER;
    private static final String REGEX_ORDINAL_LETTER;
    private static final String REPLACE_GROUP;
    private static final String REGEX_WORD_DEFINITE_LENGTH;
    private static final String REGEX_CONSONANT_WORD;
    private static final String BLANK;
    private static final String SPACE;

    static {
        String ls = System.getProperty("line.separator");
        REGEX_NOT_SPACE_LETTER = String.format("([^\\p{L}\\s]+)(%s)*",
                ls);
        REGEX_ORDINAL_LETTER = "(\\b\\S{%d})(\\S)(\\S*\\b)";
        REPLACE_GROUP = "$1%s$3";
        REGEX_WORD_DEFINITE_LENGTH = "\\b\\p{L}{%d}\\b";
        REGEX_CONSONANT_WORD =
                "\\b[\\p{L}&&[^\\d‡Â∏ËÓÛ˚˝˛ˇ¿≈®»Œ”€›ﬁﬂaeiouAEIOU]][\\S]{%d}\\b";
        BLANK = "";
        SPACE = " ";
    }

    @Override
    public String replaceCharInWord(String text, int index,
                                    char charReplacement) {
        String regEx = String.format(REGEX_ORDINAL_LETTER, index - 1);
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(String.format(REPLACE_GROUP, charReplacement));
        return text;
    }

    @Override
    public String replaceOneWithAnother(String text, String target,
                                        String replacement) {
        Pattern pattern = Pattern.compile(target);
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(replacement);
        return text;
    }

    @Override
    public String replaceWordsToSubstring(String text, int wordLength,
                                          String substring) {
        String regEx = String.format(REGEX_WORD_DEFINITE_LENGTH, wordLength);
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(substring);
        return text;
    }

    @Override
    public String deleteAllNotSpaceOrLetter(String text) {
        String regEx = REGEX_NOT_SPACE_LETTER;
        Pattern pattern = Pattern.compile(regEx, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(SPACE);
        return text;
    }

    @Override
    public String deleteConsonantWords(String text, int wordLength) {
        String regEx = String.format(REGEX_CONSONANT_WORD, wordLength - 1);
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(BLANK);
        return text;
    }
}
