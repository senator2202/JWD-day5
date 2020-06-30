package by.kharitonov.day5.service.impl;

import by.kharitonov.day5.service.TextProcessing;

import java.util.Arrays;

public class CharTextProcessingImpl implements TextProcessing {
    @Override
    public String replaceCharInWord(String text, int index,
                                    char charReplacement) {
        char[] data = text.toCharArray();
        for (int i = 0; i < data.length; i++) {
            int j = i;
            for (; j < data.length && !isWordBoundary(data, j); j++) ;
            if ((j - i) >= index) {
                data[i + index - 1] = charReplacement;
            }
            i = j;
        }
        return new String(data);
    }

    @Override
    public String replaceOneWithAnother(String text, String target,
                                        String replacement) {
        char[] data = text.toCharArray();
        char[] charsTarget = target.toCharArray();
        int delta = target.length() - replacement.length();
        for (int i = 0; i < data.length; i++) {
            boolean equals = true;
            for (int j = 0; j < target.length(); j++) {
                if (data[i + j] != charsTarget[j]) {
                    equals = false;
                    break;
                }
            }
            if (equals) {
                data = replace(data, i, i + target.length(),
                        replacement.toCharArray());
                i += delta;
            }
        }
        return new String(data);
    }

    @Override
    public String replaceWordsToSubstring(String text, int wordLength,
                                          String substring) {
        char[] data = text.toCharArray();
        int delta;
        for (int i = 0; i < data.length; i++) {
            delta = 0;
            int j = i;
            for (; j < data.length && !isWordBoundary(data, j); j++) ;
            if ((j - i) == wordLength) {
                data = replace(data, i, j, substring.toCharArray());
                delta = substring.length() - wordLength;
            }
            i = j + delta;
        }
        return new String(data);
    }

    private boolean isWordBoundary(char[] data, int index) {
        char ch = data[index];
        char chNext = index == data.length - 1 ? ' ' : data[index + 1];
        boolean result = false;
        if (index == data.length - 1) {
            return true;
        }
        if (ch == ' ' || ch == '\n') {
            result = true;
        }
        if ((ch == '?' || ch == ',' || ch == '.' ||
                ch == '!' || ch == ':' || ch == ';') &&
                (chNext == ' ' || chNext == '\r' || chNext == '\n')) {
            result = true;
        }
        return result;
    }

    private char[] replace(char[] data, int start, int end, char[] sequence) {
        int delta = sequence.length - (end - start + 1);
        int length = data.length + delta + 1;
        char[] newData = new char[length];
        char[] head = Arrays.copyOfRange(data, 0, start);
        char[] tail = Arrays.copyOfRange(data, end, data.length);
        System.arraycopy(head, 0, newData, 0, head.length);
        System.arraycopy(sequence, 0, newData, head.length, sequence.length);
        System.arraycopy(tail, 0, newData, head.length + sequence.length,
                tail.length);
        return newData;
    }

    @Override
    public String deleteAllNotSpaceOrLetter(String text) {
        char[] data = text.toCharArray();
        int delta;
        for (int i = 0; i < data.length; i++) {
            int j = i;
            delta = 0;
            for (; j < data.length && !isSpaceOrLetter(data[j]); j++) ;
            if (j != i) {
                data = replace(data, i, j, " ".toCharArray());
                delta = i - j;
            }
            i = j + delta;
        }
        return new String(data);
    }

    private boolean isSpaceOrLetter(char character) {
        return (Character.isLetter(character) ||
                character == ' ');
    }

    @Override
    public String deleteConsonantWords(String text, int wordLength) {
        char[] data = text.toCharArray();
        int delta;
        for (int i = 0; i < data.length; i++) {
            delta = 0;
            int j = i;
            for (; j < data.length && !isWordBoundary(data, j); j++) ;
            if ((j - i) == wordLength && isConsonant(data[i])) {
                data = replace(data, i, j, "".toCharArray());
                delta = i - j;
            }
            i = j + delta;
        }
        return new String(data);
    }

    private boolean isConsonant(char character) {
        char ch = Character.toLowerCase(character);
        return (ch == 'á' ||
                ch == 'â' ||
                ch == 'ã' ||
                ch == 'ä' ||
                ch == 'æ' ||
                ch == 'ç' ||
                ch == 'é' ||
                ch == 'ê' ||
                ch == 'ë' ||
                ch == 'ì' ||
                ch == 'í' ||
                ch == 'ï' ||
                ch == 'ð' ||
                ch == 'ñ' ||
                ch == 'ò' ||
                ch == 'ô' ||
                ch == 'õ' ||
                ch == 'ö' ||
                ch == '÷' ||
                ch == 'ø' ||
                ch == 'ù' ||
                ch == 'b' ||
                ch == 'c' ||
                ch == 'd' ||
                ch == 'f' ||
                ch == 'g' ||
                ch == 'h' ||
                ch == 'j' ||
                ch == 'k' ||
                ch == 'l' ||
                ch == 'm' ||
                ch == 'n' ||
                ch == 'p' ||
                ch == 'q' ||
                ch == 'r' ||
                ch == 's' ||
                ch == 't' ||
                ch == 'v' ||
                ch == 'w' ||
                ch == 'x' ||
                ch == 'z');
    }
}
