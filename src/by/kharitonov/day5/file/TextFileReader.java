package by.kharitonov.day5.file;

import by.kharitonov.day5.exception.TextException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextFileReader {
    public String readToString(String fileName) throws TextException {
        try {
            return new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            throw new TextException("Wrong file name!");
        }
    }
}
