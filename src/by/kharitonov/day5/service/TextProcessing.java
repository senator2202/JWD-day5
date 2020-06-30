package by.kharitonov.day5.service;

public interface TextProcessing {
    String replaceCharInWord(String text, int index,
                             char charReplacement);

    String replaceOneWithAnother(String text, String target,
                                 String replacement);

    String replaceWordsToSubstring(String text, int wordLength,
                                   String substring);

    String deleteAllNotSpaceOrLetter(String text);

    String deleteConsonantWords(String text, int wordLength);
}
