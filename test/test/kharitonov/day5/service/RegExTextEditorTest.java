package test.kharitonov.day5.service;

import by.kharitonov.day5.enumeration.TextData;
import by.kharitonov.day5.service.RegExTextEditor;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RegExTextEditorTest {
    private final RegExTextEditor service = new RegExTextEditor();

    @Test
    public void testReplaceCharInWord() {
        String sourceText = TextData.REPLACE_CHAR_IN_WORD.getTextBefore();
        String expectedText = TextData.REPLACE_CHAR_IN_WORD.getTextAfter();
        String actualText = service.replaceCharInWord(sourceText, 2, '!');
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void testChangePAToPO() {
        String sourceText = TextData.REPLACE_PA_TO_PO.getTextBefore();
        String expectedText = TextData.REPLACE_PA_TO_PO.getTextAfter();
        String actualText = service.changePAToPO(sourceText);
        assertEquals(actualText, expectedText);
    }

    @Test
    public void testReplaceWordsToSubstring() {
        String sourceText = TextData.REPLACE_WORD_SUBSTRING.getTextBefore();
        String expectedText = TextData.REPLACE_WORD_SUBSTRING.getTextAfter();
        String actualText = service.
                replaceWordsToSubstring(sourceText, 7, "������");
        assertEquals(actualText, expectedText);
    }

    @Test
    public void testDeleteAllNotSpaceOrLetter() {
        String sourceText = TextData.DELETE_NOT_LETTERS.getTextBefore();
        String expectedText = TextData.DELETE_NOT_LETTERS.getTextAfter();
        String actualText = service.
                deleteAllNotSpaceOrLetter(sourceText);
        assertEquals(actualText, expectedText);
    }

    @Test
    public void testDeleteConsonantWords() {
        String sourceText = TextData.DELETE_CONSONANT_WORDS.getTextBefore();
        String expectedText = TextData.DELETE_CONSONANT_WORDS.getTextAfter();
        String actualText = service.deleteConsonantWords(sourceText, 7);
        assertEquals(actualText, expectedText);
    }
}