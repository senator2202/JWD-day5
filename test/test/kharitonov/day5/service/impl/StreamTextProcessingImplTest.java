package test.kharitonov.day5.service.impl;

import by.kharitonov.day5.service.impl.StreamTextProcessingImpl;
import by.kharitonov.day5.type.TextProcessingData;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class StreamTextProcessingImplTest {
    private StreamTextProcessingImpl processor = new StreamTextProcessingImpl();

    @Test
    public void testReplaceCharInWord() {
        String sourceText = TextProcessingData.SOURCE_TEXT;
        String expectedText = TextProcessingData.REPLACED_CHAR_IN_WORDS;
        String actualTextText = processor.replaceCharInWord(sourceText, 2, '!');
        assertEquals(actualTextText, expectedText);
    }

    @Test
    public void testReplaceOneWithAnother() {
        String sourceText = TextProcessingData.SOURCE_TEXT;
        String expectedText = TextProcessingData.REPLACED_ONE_TO_ANOTHER;
        String actualText = processor.replaceOneWithAnother(sourceText, "–¿", "–Œ");
        assertEquals(actualText, expectedText);
    }

    @Test
    public void testReplaceWordsToSubstring() {
        String sourceText = TextProcessingData.SOURCE_TEXT;
        String expectedText = TextProcessingData.REPLACED_WORD_TO_SUBSTRING;
        String actualText = processor.
                replaceWordsToSubstring(sourceText, 7, "«¿Ã≈Õ¿");
        assertEquals(actualText, expectedText);
    }

    @Test
    public void testDeleteAllNotSpaceOrLetter() {
        String sourceText = TextProcessingData.SOURCE_TEXT;
        String expectedText = TextProcessingData.DELETED_NOT_LETTERS;
        String actualText = processor.deleteAllNotSpaceOrLetter(sourceText);
        assertEquals(actualText, expectedText);
    }

    @Test
    public void testDeleteConsonantWords() {
        String sourceText = TextProcessingData.SOURCE_TEXT;
        String expectedText = TextProcessingData.DELETED_CONSONANT_WORDS;
        String actualText = processor.deleteConsonantWords(sourceText, 7);
        assertEquals(actualText, expectedText);
    }
}