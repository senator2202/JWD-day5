package test.kharitonov.day5.service;

import by.kharitonov.day5.enumeration.TextData;
import by.kharitonov.day5.service.StringHandlingService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class StringHandlingServiceTest {
    private final StringHandlingService stringHandlingService =
            new StringHandlingService();

    @Test
    public void testReplaceCharInWord() {
        String actual = stringHandlingService.
                replaceCharInWord(TextData.REPLACE_CHAR_IN_WORD.getTextBefore(),
                        2, '!');
        assertEquals(actual, TextData.REPLACE_CHAR_IN_WORD.getTextAfter());
    }

    @Test
    public void testChangePAToPO() {
        String actual = stringHandlingService.
                changePAToPO(TextData.REPLACE_PA_TO_PO.getTextBefore());
        assertEquals(actual, TextData.REPLACE_PA_TO_PO.getTextAfter());
    }

    @Test
    public void testReplaceWordsToSubstring() {
        String sourceText = TextData.REPLACE_WORD_SUBSTRING.getTextBefore();
        String actual = stringHandlingService.
                replaceWordsToSubstring(sourceText, 5, "«¿Ã≈Õ¿");
        assertEquals(actual, TextData.REPLACE_WORD_SUBSTRING.getTextAfter());
    }

    @Test
    public void testDeleteAllNotSpaceOrLetter() {
        String sourceText = TextData.DELETE_NOT_LETTERS.getTextBefore();
        String actual = stringHandlingService.
                deleteAllNotSpaceOrLetter(sourceText);
        assertEquals(actual, TextData.DELETE_NOT_LETTERS.getTextAfter());
    }

    @Test
    public void testDeleteConsonantWords() {
        String sourceText = TextData.DELETE_CONSONANT_WORDS.getTextBefore();
        String actual = stringHandlingService.
                deleteConsonantWords(sourceText, 5);
        assertEquals(actual, TextData.DELETE_CONSONANT_WORDS.getTextAfter());
    }
}