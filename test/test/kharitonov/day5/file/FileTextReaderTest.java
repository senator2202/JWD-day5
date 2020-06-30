package test.kharitonov.day5.file;

import by.kharitonov.day5.exception.TextHandlingException;
import by.kharitonov.day5.file.FileTextReader;
import org.testng.annotations.Test;
import type.TextHandlingResults;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class FileTextReaderTest {
    private final FileTextReader fileTextReader = new FileTextReader();

    @Test(groups = {"fileChar", "fileRegEx", "fileString"})
    public void testRead() {
        String fileName = "resources\\SourceText.txt";
        String expectedString = TextHandlingResults.SOURCE_TEXT;
        try {
            String actual = fileTextReader.read(fileName);
            assertEquals(actual, expectedString);
        } catch (TextHandlingException e) {
            fail();
        }
    }

    @Test(expectedExceptions = TextHandlingException.class)
    public void testReadException() throws TextHandlingException {
        fileTextReader.read("WrongFile.txt");
    }
}