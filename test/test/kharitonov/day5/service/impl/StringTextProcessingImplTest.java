package test.kharitonov.day5.service.impl;

import by.kharitonov.day5.service.impl.StringTextProcessingImpl;
import org.testng.annotations.Test;
import by.kharitonov.day5.type.TextProcessingResults;

import static org.testng.Assert.assertEquals;

public class StringTextProcessingImplTest {
    private final StringTextProcessingImpl processor =
            new StringTextProcessingImpl();

    @Test(groups = {"consoleString", "fileString"}, priority = 1)
    public void testReplaceCharInWord() {
        String sourceText = TextProcessingResults.SOURCE_TEXT;
        String expectedText = TextProcessingResults.REPLACED_CHAR_IN_WORDS;
        String actualTextText = processor.replaceCharInWord(sourceText, 2, '!');
        assertEquals(actualTextText, expectedText);
    }

    @Test(groups = {"consoleString", "fileString"}, priority = 2)
    public void testReplaceOneWithAnother() {
        String sourceText = TextProcessingResults.SOURCE_TEXT;
        String expectedText = TextProcessingResults.REPLACED_ONE_TO_ANOTHER;
        String actualText = processor.replaceOneWithAnother(sourceText, "–¿", "–Œ");
        assertEquals(actualText, expectedText);
    }

    @Test(groups = {"consoleString", "fileString"}, priority = 3)
    public void testReplaceWordsToSubstring() {
        String sourceText = TextProcessingResults.SOURCE_TEXT;
        String expectedText = TextProcessingResults.REPLACED_WORD_TO_SUBSTRING;
        String actualText = processor.
                replaceWordsToSubstring(sourceText, 7, "«¿Ã≈Õ¿");
        assertEquals(actualText, expectedText);
    }

    @Test(groups = {"consoleString", "fileString"}, priority = 4)
    public void testDeleteAllNotSpaceOrLetter() {
        String sourceText = TextProcessingResults.SOURCE_TEXT;
        String expectedText = TextProcessingResults.DELETED_NOT_LETTERS;
        String actualText = processor.deleteAllNotSpaceOrLetter(sourceText);
        assertEquals(actualText, expectedText);
    }

    @Test(groups = {"consoleString", "fileString"}, priority = 5)
    public void testDeleteConsonantWords() {
        String sourceText = TextProcessingResults.SOURCE_TEXT;
        String expectedText = TextProcessingResults.DELETED_CONSONANT_WORDS;
        String actualText = processor.deleteConsonantWords(sourceText, 7);
        assertEquals(actualText, expectedText);
    }
}