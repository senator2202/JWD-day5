package test.kharitonov.day5.service;

import by.kharitonov.day5.enumeration.TextData;
import by.kharitonov.day5.service.RegExTextHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RegExTextHandlerTest {
    private final RegExTextHandler handler = new RegExTextHandler();

    @Test(groups = {"consoleRegEx", "fileRegEx"}, priority = 1)
    public void testReplaceCharInWord() {
        String sourceText = TextData.REPLACE_CHAR_IN_WORD.getTextBefore();
        String expectedText = TextData.REPLACE_CHAR_IN_WORD.getTextAfter();
        String actualText = handler.replaceCharInWord(sourceText, 2, '!');
        Assert.assertEquals(actualText, expectedText);
    }

    @Test(groups = {"consoleRegEx", "fileRegEx"}, priority = 2)
    public void testChangePAToPO() {
        String sourceText = TextData.REPLACE_PA_TO_PO.getTextBefore();
        String expectedText = TextData.REPLACE_PA_TO_PO.getTextAfter();
        String actualText = handler.changePAToPO(sourceText);
        assertEquals(actualText, expectedText);
    }

    @Test(groups = {"consoleRegEx", "fileRegEx"}, priority = 3)
    public void testReplaceWordsToSubstring() {
        String sourceText = TextData.REPLACE_WORD_SUBSTRING.getTextBefore();
        String expectedText = TextData.REPLACE_WORD_SUBSTRING.getTextAfter();
        String actualText = handler.
                replaceWordsToSubstring(sourceText, 7, "«¿Ã≈Õ¿");
        assertEquals(actualText, expectedText);
    }

    @Test(groups = {"consoleRegEx", "fileRegEx"}, priority = 4)
    public void testDeleteAllNotSpaceOrLetter() {
        String sourceText = TextData.DELETE_NOT_LETTERS.getTextBefore();
        String expectedText = TextData.DELETE_NOT_LETTERS.getTextAfter();
        String actualText = handler.
                deleteAllNotSpaceOrLetter(sourceText);
        assertEquals(actualText, expectedText);
    }

    @Test(groups = {"consoleRegEx", "fileRegEx"}, priority = 5)
    public void testDeleteConsonantWords() {
        String sourceText = TextData.DELETE_CONSONANT_WORDS.getTextBefore();
        String expectedText = TextData.DELETE_CONSONANT_WORDS.getTextAfter();
        String actualText = handler.deleteConsonantWords(sourceText, 7);
        assertEquals(actualText, expectedText);
    }
}