package by.kharitonov.day5.service.impl;

public class TextProcessingUtils {
    static final String BLANK = "";
    static final String SPACE = " ";
    static final String CONSONANTS =
            "���������������������bcdfghjklmnpqrstvwxz";

    protected boolean isConsonant(char character) {
        char ch = Character.toLowerCase(character);
        boolean flag = false;
        for (int i = 0; i < CONSONANTS.length(); i++) {
            if (ch == CONSONANTS.charAt(i)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
