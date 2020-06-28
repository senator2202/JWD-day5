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
        String sourceText = TextData.REPLACE_CHAR_IN_WORD.getTextBefore();
        String expectedText = TextData.REPLACE_CHAR_IN_WORD.getTextAfter();
        String actual = stringHandlingService.
                replaceCharInWord(sourceText, 2, '!');
        assertEquals(actual, expectedText);
    }

    @Test
    public void testChangePAToPO() {
        String sourceText = TextData.REPLACE_PA_TO_PO.getTextBefore();
        String expectedText = TextData.REPLACE_PA_TO_PO.getTextAfter();
        String actual = stringHandlingService.changePAToPO(sourceText);
        assertEquals(actual, expectedText);
    }

    @Test
    public void testReplaceWordsToSubstring() {
        String sourceText = TextData.REPLACE_WORD_SUBSTRING.getTextBefore();
        String expectedText = TextData.REPLACE_WORD_SUBSTRING.getTextAfter();
        String actual = stringHandlingService.
                replaceWordsToSubstring(sourceText, 7, "������");
        assertEquals(actual, expectedText);
    }

    @Test
    public void testDeleteAllNotSpaceOrLetter() {
        String sourceText = TextData.DELETE_NOT_LETTERS.getTextBefore();
        String expectedText = TextData.DELETE_NOT_LETTERS.getTextAfter();
        String actual = stringHandlingService.
                deleteAllNotSpaceOrLetter(sourceText);
        assertEquals(actual, expectedText);
    }

    @Test
    public void testDeleteConsonantWords() {
        String sourceText = TextData.DELETE_CONSONANT_WORDS.getTextBefore();
        String expectedText = TextData.DELETE_CONSONANT_WORDS.getTextAfter();
        String actual = stringHandlingService.
                deleteConsonantWords(sourceText, 7);
        assertEquals(actual, expectedText);
    }
}