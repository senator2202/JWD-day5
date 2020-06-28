package by.kharitonov.day5.file;

import by.kharitonov.day5.exception.TextHandlingException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileTextReader {
    public String readToString(String fileName) throws TextHandlingException {
        try {
            return new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            throw new TextHandlingException("Wrong file name!");
        }
    }
}
