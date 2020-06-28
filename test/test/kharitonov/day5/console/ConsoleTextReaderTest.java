package test.kharitonov.day5.console;

import by.kharitonov.day5.console.ConsoleTextReader;
import by.kharitonov.day5.exception.TextHandlingException;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ConsoleTextReaderTest {
    private ConsoleTextReader consoleTextReader = new ConsoleTextReader();
    private final String SOURCE_TEXT;

    {
        String ls = System.getProperty("line.separator");
        SOURCE_TEXT = "Однажды к пеликану неожиданно подошёл человек." +
                " В это время котёнок сидел у птицы в клюве." + ls +
                "Пеликан затолкал котёнка в глоточный мешок, " +
                "сомкнул клюв и взмыл в воздух.";
    }

    @Test
    public void testReadText() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in =
                new ByteArrayInputStream(SOURCE_TEXT.getBytes());
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
        assertEquals(text, SOURCE_TEXT);
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