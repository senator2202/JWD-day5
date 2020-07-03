package by.kharitonov.day5.service;

public class TextProcessingUtils {
    protected static final String BLANK = "";
    protected static final String SPACE = " ";
    protected static final String CONSONANTS =
            "áâãäæçéêëìíïğñòôõö÷øùbcdfghjklmnpqrstvwxz";

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
