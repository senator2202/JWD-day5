package test.kharitonov.day5.file;

import by.kharitonov.day5.enumeration.TextData;
import by.kharitonov.day5.exception.TextHandlingException;
import by.kharitonov.day5.file.FileTextReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class FileTextReaderTest {
    private final FileTextReader fileTextReader = new FileTextReader();

    @DataProvider(name = "dataRead")
    @Test
    public Object[][] dataRead() {
        return new Object[][]{
                {"resources\\ReplaceCharInWord.txt",
                        TextData.REPLACE_CHAR_IN_WORD.getTextBefore()},
                {"resources\\ReplacePAToPO.txt",
                        TextData.REPLACE_PA_TO_PO.getTextBefore()},
                {"resources\\ReplaceWordSubstring.txt",
                        TextData.REPLACE_WORD_SUBSTRING.getTextBefore()},
                {"resources\\DeleteNotLetters.txt",
                        TextData.DELETE_NOT_LETTERS.getTextBefore()},
                {"resources\\DeleteConsonantWords.txt",
                        TextData.DELETE_CONSONANT_WORDS.getTextBefore()}
        };
    }

    @Parameters({"fileName", "expectedString"})
    @Test(dataProvider = "dataRead")
    public void testRead(String fileName, String expectedString) {
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