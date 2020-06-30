package by.kharitonov.day5.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTextHandler {
    public String replaceCharInWord(String text, int index,
                                    char charReplacement) {
        String regEx = "\\b[\\S]{" + index + ",}\\b";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String temp = "" + charReplacement;
            int start = matcher.start()+index-1;
            int end = start+1;
            text = replace(text, start,end, temp);
        }
        return text;
    }

    private String replace(String text, int start, int end,
                           String replacement) {
        String head = text.substring(0, start);
        String tail = text.substring(end);
        return head + replacement + tail;
    }

    public String changeOneToAnother(String text, String target,
                                     String replacement) {
        Pattern pattern = Pattern.compile(target);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            text = replace(text, matcher.start(), matcher.end(), replacement);
        }
        return text;
    }

    public String replaceWordsToSubstring(String text, int wordLength,
                                          String substring) {
        String regEx = "\\b[à-ÿÀ-ß\\w¸¨]{" + wordLength + "}\\b";
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
        String regEx = "([^à-ÿÀ-ßa-zA-Z¸¨\\s]+)(\\r\\n)*";
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
