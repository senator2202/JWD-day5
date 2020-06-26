package by.kharitonov.day5.service;

import java.util.List;

public class StringHandlingService {
    /*index starts from 1*/
    public void replaceCharInWord(String text, int index,
                                  char charReplacement) {
        StringBuilder stringBuilder = new StringBuilder(text);
        String []words = splitToWords(text);
    }

    private String [] splitToWords(String text) {
        return text.split("[\\s\\n,.]");
    }
}
