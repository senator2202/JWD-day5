package by.kharitonov.day5.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExHandlingService {
    private static final String REGEX_WORDS = "\\b[à-ÿÀ-ß\\w¸]+\\b";
    private static final String REGEX_PA = "ÐÀ";
    private static final String REGEX_SPLIT_NOT_SPACE_LETTER =
            "[à-ÿÀ-ßa-zA-Z\\s]+";

    public String replaceCharInWord(String text, int index,
                                    char charReplacement) {
        Pattern pattern = Pattern.compile(REGEX_WORDS);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            if (word.length() >= index) {
                StringBuilder sb = new StringBuilder(word);
                sb.setCharAt(index - 1, charReplacement);
                text = replace(text, matcher.start(),
                        matcher.end(), sb.toString());
            }
        }
        return text;
    }

    private String replace(String text, int start, int end,
                           String replacement) {
        String head = text.substring(0, start);
        String tail = text.substring(end);
        return head + replacement + tail;
    }

    public String changePAToPO(String text) {
        Pattern pattern = Pattern.compile(REGEX_PA);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            text = replace(text, matcher.start(), matcher.end(), "ÐÎ");
        }
        return text;
    }

    public String replaceWordsToSubstring(String text, int wordLength,
                                          String substring) {
        Pattern pattern = Pattern.compile(REGEX_WORDS);
        Matcher matcher = pattern.matcher(text);
        int delta = 0;
        while (matcher.find()) {
            String word = matcher.group();
            if (word.length() == wordLength) {
                int start = matcher.start() + delta;
                int end = matcher.end() + delta;
                text = replace(text, start, end, substring);
                delta += substring.length() - wordLength;
            }
        }
        return text;
    }

    public String deleteAllNotSpaceOrLetter(String text) {
        Pattern pattern = Pattern.compile(REGEX_SPLIT_NOT_SPACE_LETTER);
        Matcher matcher = pattern.matcher(text);
        int delta = 0;
        int indexBefore = 0;
        int start;
        int end;
        while (matcher.find()) {
            start = indexBefore - delta;
            end = matcher.start() - delta;
            text = replace(text, start, end, " ");
            delta += end - start - 1;
            indexBefore = matcher.end();
        }
        start = indexBefore - delta;
        end = text.length();
        text = replace(text, start, end, " ");
        return text;
    }

    public String deleteConsonantWords(String text, int wordLength) {
        Pattern pattern = Pattern.compile(REGEX_WORDS);
        Matcher matcher = pattern.matcher(text);
        int delta = 0;
        while (matcher.find()) {
            String word = matcher.group();
            if (word.length() == wordLength && startsConsonant(word)) {
                int start = matcher.start() + delta;
                int end = matcher.end() + delta;
                text = replace(text, start, end, "");
                delta -= wordLength;
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
