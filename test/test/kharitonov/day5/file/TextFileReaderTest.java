package test.kharitonov.day5.file;

import by.kharitonov.day5.exception.TextHandlingException;
import by.kharitonov.day5.file.TextFileReader;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class TextFileReaderTest {
    private final TextFileReader textFileReader = new TextFileReader();
    private final String TEXT;

    {
        String ls = System.getProperty("line.separator");
        TEXT = "Однажды к пеликану неожиданно подошёл человек. " +
                "В это время котёнок сидел у птицы в клюве." + ls +
                "Пеликан затолкал котёнка в глоточный мешок, " +
                "сомкнул клюв и взмыл в воздух.";
    }

    @Test
    public void testReadBytesToString() {
        try {
            String actual = textFileReader.readToString("resources\\" +
                    "Text.txt");
            assertEquals(actual, TEXT);
        } catch (TextHandlingException e) {
            fail();
        }
    }
}