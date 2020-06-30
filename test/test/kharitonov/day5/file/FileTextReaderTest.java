package test.kharitonov.day5.file;

import by.kharitonov.day5.exception.TextProcessingException;
import by.kharitonov.day5.file.FileTextReader;
import org.testng.annotations.Test;
import type.TextProcessingResults;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class FileTextReaderTest {
    private final FileTextReader fileTextReader = new FileTextReader();

    @Test(groups = {"fileChar", "fileRegEx", "fileString"})
    public void testRead() {
        String fileName = "resources\\SourceText.txt";
        String expectedString = TextProcessingResults.SOURCE_TEXT;
        try {
            String actual = fileTextReader.read(fileName);
            assertEquals(actual, expectedString);
        } catch (TextProcessingException e) {
            fail();
        }
    }

    @Test(expectedExceptions = TextProcessingException.class)
    public void testReadException() throws TextProcessingException {
        fileTextReader.read("WrongFile.txt");
    }
}