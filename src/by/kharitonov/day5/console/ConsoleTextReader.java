package by.kharitonov.day5.console;

import by.kharitonov.day5.exception.TextHandlingException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleTextReader {
    public String readText() throws TextHandlingException {
        String text = "";
        String ls = System.getProperty("line.separator");
        InputStreamReader isr = new InputStreamReader(System.in);
        try {
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                text += line + ls;
            }
            StringBuilder sb = new StringBuilder(text);
            sb.replace(text.length() - ls.length() , text.length(), "");
            text = sb.toString();
            isr.close();
        } catch (IOException e) {
            throw new TextHandlingException("Error, while reading data!");
        } catch (NullPointerException e) {
            throw new TextHandlingException("Input stream has null pointer!");
        }
        return text;
    }
}
