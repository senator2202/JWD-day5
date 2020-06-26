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
        TEXT = "������� � �������� ���������� ������� �������. � ��� ����� " +
                "������ ����� � ����� � �����. ������� �������� ������ � " +
                "��������� �����, ������� ���� � ����� � ������.\n" +
                "����� ������ ��� ������ ���� �� ������, ���� ������� ��" +
                " ��������� � ������. ����� ����� ���������� � ��������" +
                " ����. �� ����� ����� ����� ��������������-������.";
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