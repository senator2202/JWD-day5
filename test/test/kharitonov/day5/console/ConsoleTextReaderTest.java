package test.kharitonov.day5.console;

import by.kharitonov.day5.console.ConsoleTextReader;
import by.kharitonov.day5.enumeration.TextData;
import by.kharitonov.day5.exception.TextHandlingException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ConsoleTextReaderTest {
    private final ConsoleTextReader consoleTextReader = new ConsoleTextReader();

    @DataProvider(name = "dataReadText")
    @Test
    public Object[][] dataReadText() {
        return new Object[][]{
                {TextData.REPLACE_CHAR_IN_WORD.getTextBefore()},
                {TextData.REPLACE_PA_TO_PO.getTextBefore()},
                {TextData.REPLACE_WORD_SUBSTRING.getTextBefore()},
                {TextData.DELETE_NOT_LETTERS.getTextBefore()},
                {TextData.DELETE_CONSONANT_WORDS.getTextBefore()}
        };
    }

    @Parameters({"inputString", "expectedString"})
    @Test(dataProvider = "dataReadText")
    public void testReadText(String inputString) {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in =
                new ByteArrayInputStream(inputString.getBytes());
        String text = "";
        System.setIn(in);
        try {
            text = consoleTextReader.readText();
        } catch (TextHandlingException e) {
            fail();
        } finally {
            System.setIn(sysInBackup);
        }
        System.setIn(sysInBackup);
        assertEquals(text, inputString);
    }

    @Test(expectedExceptions = TextHandlingException.class,
            expectedExceptionsMessageRegExp = "Input stream has null pointer!")
    public void testReadTextExceptionNull() throws TextHandlingException {
        InputStream sysInBackup = System.in;
        System.setIn(null);
        try {
            consoleTextReader.readText();
        } catch (TextHandlingException e) {
            throw new TextHandlingException(e.getMessage());
        } finally {
            System.setIn(sysInBackup);
        }
        System.setIn(sysInBackup);
    }
}