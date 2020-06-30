package test.kharitonov.day5.console;

import by.kharitonov.day5.console.ConsoleTextReader;
import by.kharitonov.day5.exception.TextHandlingException;
import org.testng.annotations.Test;
import type.TextHandlingResults;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ConsoleTextReaderTest {
    private final ConsoleTextReader consoleTextReader = new ConsoleTextReader();

    @Test(groups = {"consoleChar", "consoleRegEx", "consoleString"})
    public void testReadText() {
        String inputString = TextHandlingResults.SOURCE_TEXT;
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