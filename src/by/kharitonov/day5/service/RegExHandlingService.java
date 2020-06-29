package by.kharitonov.day5.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExHandlingService {
    public String replaceCharInWord(String text, int index,
                                    char charReplacement) {
        String regEx = "\\b\\S{" + index + "}";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String temp = "" + charReplacement;
            text = replace(text, matcher.end() - 1, matcher.end(), temp);
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
        String regEx = "ĞÀ";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            text = replace(text, matcher.start(), matcher.end(), "ĞÎ");
        }
        return text;
    }

    public String replaceWordsToSubstring(String text, int wordLength,
                                          String substring) {
        String regEx = "\\b[à-ÿÀ-ß\\w¸]{" + wordLength + "}\\b";
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

    public String deleteAllNotSpaceOrLetter(String text) {
        String regEx = "[à-ÿÀ-ßa-zA-Z\\s]+";
        Pattern pattern = Pattern.compile(regEx);
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
        String regEx = "\\b[áâãäæçêëìíïğñòôõö÷øùbcdfghjklmnpqrstvwxz" +
                "ÁÂÃÄÆÇÊËÌÍÏĞÑÒÔÕÖ×ØÙBCDFGHJKLMNPQRSTVWXZ][\\S]" +
                "{" + (wordLength - 1) + "}\\b";
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
