package by.kharitonov.day5.service;

import java.util.Arrays;

public class CharTextEditor {
    public String replaceCharInWord(String text, int index,
                                    char charReplacement) {
        char[] data = text.toCharArray();
        for (int i = 0; i < data.length; i++) {
            int j = i;
            for (; j < data.length && !isWordBoundary(data[j]); j++) ;
            if ((j - i) >= index) {
                data[i + index - 1] = charReplacement;
            }
            i = j;
        }
        return new String(data);
    }

    public String changePAToPO(String text) {
        char[] data = text.toCharArray();
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 'Ð' && data[i + 1] == 'À') {
                data[++i] = 'Î';
            }
        }
        return new String(data);
    }

    public String replaceWordsToSubstring(String text, int wordLength,
                                          String substring) {
        char[] data = text.toCharArray();
        int delta;
        for (int i = 0; i < data.length; i++) {
            delta = 0;
            int j = i;
            for (; j < data.length && !isWordBoundary(data[j]); j++) ;
            if ((j - i) == wordLength) {
                data = replace(data, i, j, substring.toCharArray());
                delta = substring.length() - wordLength;
            }
            i = j + delta;
        }
        return new String(data);
    }

    private boolean isWordBoundary(char character) {
        return character == ' ' ||
                character == '\n' ||
                character == '?' ||
                character == ',' ||
                character == '.' ||
                character == '!' ||
                character == ':' ||
                character == ';';
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

    public String deleteAllNotSpaceOrLetter(String text) {
        char[] data = text.toCharArray();
        int delta;
        for (int i = 0; i < data.length; i++) {
            delta = 0;
            int j = i;
            for (; j < data.length && !isSpaceOrLetter(data[j]); j++) ;
            if (j != i) {
                data = replace(data, i, j, " ".toCharArray());
                delta = 1 - (j - i);
            }
            i = j + delta;
        }
        return new String(data);
    }

    private boolean isSpaceOrLetter(char character) {
        return (Character.isAlphabetic(character) ||
                character == ' ' ||
                character == '\r' ||
                character == '\n');
    }

    public String deleteConsonantWords(String text, int wordLength) {
        char[] data = text.toCharArray();
        int delta;
        for (int i = 0; i < data.length; i++) {
            delta = 0;
            int j = i;
            for (; j < data.length && !isWordBoundary(data[j]); j++) ;
            if ((j - i) == wordLength && isConsonant(data[i])) {
                data = replace(data, i, j, "".toCharArray());
                delta = i-j;
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
