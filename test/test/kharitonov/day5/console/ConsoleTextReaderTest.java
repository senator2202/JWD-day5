package test.kharitonov.day5.console;

import by.kharitonov.day5.console.ConsoleTextReader;
import by.kharitonov.day5.exception.TextProcessingException;
import org.testng.annotations.Test;
import by.kharitonov.day5.type.TextProcessingData;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ConsoleTextReaderTest {
    private final ConsoleTextReader consoleTextReader = new ConsoleTextReader();

    @Test(groups = {"consoleChar", "consoleRegEx", "consoleString"})
    public void testReadText() {
        String inputString = TextProcessingData.SOURCE_TEXT;
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in =
                new ByteArrayInputStream(inputString.getBytes());
        String text = "";
        System.setIn(in);
        try {
            text = consoleTextReader.readText();
        } catch (TextProcessingException e) {
            fail();
        } finally {
            System.setIn(sysInBackup);
        }
        System.setIn(sysInBackup);
        assertEquals(text, inputString);
    }

    @Test(expectedExceptions = TextProcessingException.class,
            expectedExceptionsMessageRegExp = "Input stream has null pointer!")
    public void testReadTextExceptionNull() throws TextProcessingException {
        InputStream sysInBackup = System.in;
        System.setIn(null);
        try {
            consoleTextReader.readText();
        } catch (TextProcessingException e) {
            throw new TextProcessingException(e.getMessage());
        } finally {
            System.setIn(sysInBackup);
        }
        System.setIn(sysInBackup);
    }
}