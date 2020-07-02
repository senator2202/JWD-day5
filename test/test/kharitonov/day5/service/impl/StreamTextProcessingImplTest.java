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
}