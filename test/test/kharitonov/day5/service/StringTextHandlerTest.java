package test.kharitonov.day5.service;

import by.kharitonov.day5.service.StringTextHandler;
import org.testng.annotations.Test;
import type.TextHandlingResults;

import static org.testng.Assert.assertEquals;

public class StringTextHandlerTest {
    private final StringTextHandler handler = new StringTextHandler();

    @Test(groups = {"consoleString", "fileString"}, priority = 1)
    public void testReplaceCharInWord() {
        String sourceText = TextHandlingResults.SOURCE_TEXT;
        String expectedText = TextHandlingResults.REPLACED_CHAR_IN_WORDS;
        String actualTextText = handler.replaceCharInWord(sourceText, 2, '!');
        assertEquals(actualTextText, expectedText);
    }

    @Test(groups = {"consoleString", "fileString"}, priority = 2)
    public void testChangePAToPO() {
        String sourceText = TextHandlingResults.SOURCE_TEXT;
        String expectedText = TextHandlingResults.REPLACED_ONE_TO_ANOTHER;
        String actualText = handler.changeOneToAnother(sourceText, "–¿", "–Œ");
        assertEquals(actualText, expectedText);
    }

    @Test(groups = {"consoleString", "fileString"}, priority = 3)
    public void testReplaceWordsToSubstring() {
        String sourceText = TextHandlingResults.SOURCE_TEXT;
        String expectedText = TextHandlingResults.REPLACED_WORD_TO_SUBSTRING;
        String actualText = handler.
                replaceWordsToSubstring(sourceText, 7, "«¿Ã≈Õ¿");
        assertEquals(actualText, expectedText);
    }

    @Test(groups = {"consoleString", "fileString"}, priority = 4)
    public void testDeleteAllNotSpaceOrLetter() {
        String sourceText = TextHandlingResults.SOURCE_TEXT;
        String expectedText = TextHandlingResults.DELETED_NOT_LETTERS;
        String actualText = handler.deleteAllNotSpaceOrLetter(sourceText);
        assertEquals(actualText, expectedText);
    }

    @Test(groups = {"consoleString", "fileString"}, priority = 5)
    public void testDeleteConsonantWords() {
        String sourceText = TextHandlingResults.SOURCE_TEXT;
        String expectedText = TextHandlingResults.DELETED_CONSONANT_WORDS;
        String actualText = handler.deleteConsonantWords(sourceText, 7);
        assertEquals(actualText, expectedText);
    }
}