package test.kharitonov.day5.service;

import by.kharitonov.day5.enumeration.TextData;
import by.kharitonov.day5.service.CharTextHandler;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CharTextHandlerTest {
    private final CharTextHandler handle = new CharTextHandler();

    @Test(groups = {"consoleChar", "fileChar"}, priority = 1)
    public void testReplaceCharInWord() {
        String sourceText = TextData.REPLACE_CHAR_IN_WORD.getTextBefore();
        String expectedText = TextData.REPLACE_CHAR_IN_WORD.getTextAfter();
        String actualTextText = handle.replaceCharInWord(sourceText, 2, '!');
        assertEquals(actualTextText, expectedText);
    }

    @Test(groups = {"consoleChar", "fileChar"}, priority = 2)
    public void testChangePAToPO() {
        String sourceText = TextData.REPLACE_PA_TO_PO.getTextBefore();
        String expectedText = TextData.REPLACE_PA_TO_PO.getTextAfter();
        String actualText = handle.changePAToPO(sourceText);
        assertEquals(actualText, expectedText);
    }

    @Test(groups = {"consoleChar", "fileChar"}, priority = 3)
    public void testReplaceWordsToSubstring() {
        String sourceText = TextData.REPLACE_WORD_SUBSTRING.getTextBefore();
        String expectedText = TextData.REPLACE_WORD_SUBSTRING.getTextAfter();
        String actualText = handle.
                replaceWordsToSubstring(sourceText, 7, "«¿Ã≈Õ¿");
        assertEquals(actualText, expectedText);
    }

    @Test(groups = {"consoleChar", "fileChar"}, priority = 4)
    public void testDeleteAllNotSpaceOrLetter() {
        String sourceText = TextData.DELETE_NOT_LETTERS.getTextBefore();
        String expectedText = TextData.DELETE_NOT_LETTERS.getTextAfter();
        String actualText = handle.deleteAllNotSpaceOrLetter(sourceText);
        assertEquals(actualText, expectedText);
    }

    @Test(groups = {"consoleChar", "fileChar"}, priority = 5)
    public void testDeleteConsonantWords() {
        String sourceText = TextData.DELETE_CONSONANT_WORDS.getTextBefore();
        String expectedText = TextData.DELETE_CONSONANT_WORDS.getTextAfter();
        String actualText = handle.deleteConsonantWords(sourceText, 7);
        assertEquals(actualText, expectedText);
    }
}