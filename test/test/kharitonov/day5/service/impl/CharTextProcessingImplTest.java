package test.kharitonov.day5.service.impl;

import by.kharitonov.day5.service.impl.CharTextProcessingImpl;
import by.kharitonov.day5.type.TextProcessingData;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CharTextProcessingImplTest {
    private final CharTextProcessingImpl processor =
            new CharTextProcessingImpl();

    @Test(groups = {"consoleChar", "fileChar"}, priority = 1)
    public void testReplaceCharInWord() {
        String sourceText = TextProcessingData.SOURCE_TEXT;
        String expectedText = TextProcessingData.REPLACED_CHAR_IN_WORDS;
        String actualTextText = processor.replaceCharInWord(sourceText, 2, '!');
        assertEquals(actualTextText, expectedText);
    }

    @Test(groups = {"consoleChar", "fileChar"}, priority = 2)
    public void testReplaceOneWithAnother() {
        String sourceText = TextProcessingData.SOURCE_TEXT;
        String expectedText = TextProcessingData.REPLACED_ONE_TO_ANOTHER;
        String actualText = processor.replaceOneWithAnother(sourceText, "��",
                "��");
        assertEquals(actualText, expectedText);
    }

    @Test(groups = {"consoleChar", "fileChar"}, priority = 3)
    public void testReplaceWordsToSubstring() {
        String sourceText = TextProcessingData.SOURCE_TEXT;
        String expectedText = TextProcessingData.REPLACED_WORD_TO_SUBSTRING;
        String actualText = processor.
                replaceWordsToSubstring(sourceText, 7, "������");
        assertEquals(actualText, expectedText);
    }

    @Test(groups = {"consoleChar", "fileChar"}, priority = 4)
    public void testDeleteAllNotSpaceOrLetter() {
        String sourceText = TextProcessingData.SOURCE_TEXT;
        String expectedText = TextProcessingData.DELETED_NOT_LETTERS;
        String actualText = processor.deleteAllNotSpaceOrLetter(sourceText);
        assertEquals(actualText, expectedText);
    }

    @Test(groups = {"consoleChar", "fileChar"}, priority = 5)
    public void testDeleteConsonantWords() {
        String sourceText = TextProcessingData.SOURCE_TEXT;
        String expectedText = TextProcessingData.DELETED_CONSONANT_WORDS;
        String actualText = processor.deleteConsonantWords(sourceText, 7);
        assertEquals(actualText, expectedText);
    }
}