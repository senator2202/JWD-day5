package test.kharitonov.day5.file;

import by.kharitonov.day5.exception.TextException;
import by.kharitonov.day5.file.TextFileReader;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class TextFileReaderTest {
    private final TextFileReader textFileReader = new TextFileReader();
    private final String TEXT;

    {
        TEXT = "Однажды к пеликану неожиданно подошёл человек. В это время " +
                "котёнок сидел у птицы в клюве. Пеликан затолкал котёнка в " +
                "глоточный мешок, сомкнул клюв и взмыл в воздух.\n" +
                "Птица делала над озером круг за кругом, пока человек не" +
                " спрятался в кустах. Тогда птица опустилась и раскрыла" +
                " клюв. На землю важно вышел путешественник-котёнок.";
    }

    @Test
    public void testReadBytesToString() {
        try {
            String actual = textFileReader.readToString("resources\\" +
                    "Text.txt");
            assertEquals(actual, TEXT);
        } catch (TextException e) {
            fail();
        }
    }
}