package test.kharitonov.day5.service;

import by.kharitonov.day5.enumeration.TextData;
import by.kharitonov.day5.service.RegExTextHandler;
import org.testng.Assert;
import org.testng.annotations.Test;
import type.TextHandlingResults;

import static org.testng.Assert.assertEquals;

public class RegExTextHandlerTest {
    private final RegExTextHandler handler = new RegExTextHandler();

    @Test(groups = {"consoleRegEx", "fileRegEx"}, priority = 1)
    public void testReplaceCharInWord() {
        String sourceText = TextHandlingResults.SOURCE_TEXT;
        String expectedText = TextHandlingResults.REPLACED_CHAR_IN_WORDS;
        String actualTextText = handler.replaceCharInWord(sourceText, 2, '!');
        assertEquals(actualTextText, expectedText);
    }

    @Test(groups = {"consoleRegEx", "fileRegEx"}, priority = 2)
    public void testChangeOneToAnother() {
        String sourceText = TextHandlingResults.SOURCE_TEXT;
        String expectedText = TextHandlingResults.REPLACED_ONE_TO_ANOTHER;
        String actualText = handler.changeOneToAnother(sourceText, "–¿", "–Œ");
        assertEquals(actualText, expectedText);
    }

    @Test(groups = {"consoleRegEx", "fileRegEx"}, priority = 3)
    public void testReplaceWordsToSubstring() {
        String sourceText = TextHandlingResults.SOURCE_TEXT;
        String expectedText = TextHandlingResults.REPLACED_WORD_TO_SUBSTRING;
        String actualText = handler.
                replaceWordsToSubstring(sourceText, 7, "«¿Ã≈Õ¿");
        assertEquals(actualText, expectedText);
    }

    @Test(groups = {"consoleRegEx", "fileRegEx"}, priority = 4)
    public void testDeleteAllNotSpaceOrLetter() {
        String sourceText = TextHandlingResults.SOURCE_TEXT;
        String expectedText = TextHandlingResults.DELETED_NOT_LETTERS;
        String actualText = handler.deleteAllNotSpaceOrLetter(sourceText);
        assertEquals(actualText, expectedText);
    }

    @Test(groups = {"consoleRegEx", "fileRegEx"}, priority = 5)
    public void testDeleteConsonantWords() {
        String sourceText = TextHandlingResults.SOURCE_TEXT;
        String expectedText = TextHandlingResults.DELETED_CONSONANT_WORDS;
        String actualText = handler.deleteConsonantWords(sourceText, 7);
        assertEquals(actualText, expectedText);
    }
}