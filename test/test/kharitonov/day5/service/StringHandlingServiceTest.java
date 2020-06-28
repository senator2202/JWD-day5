package test.kharitonov.day5.service;

import by.kharitonov.day5.enumeration.TextData;
import by.kharitonov.day5.service.StringHandlingService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class StringHandlingServiceTest {
    private StringHandlingService stringHandlingService =
            new StringHandlingService();
    private final String SOURCE_TEXT;
    private final String TEXT_INDEX_CHAR;
    private final String TEXT_PA;
    private final String TEXT_PO;
    private final String TEXT_SUBSTRING;
    private final String TEXT_EXTRA_SYMBALS;
    private final String TEXT_WITHOUT_EXTRA_SYMBALS;
    private final String TEXT_WITHOUT_CONSONANT;

    {
        String ls = System.getProperty("line.separator");
        SOURCE_TEXT = "������� � �������� ���������� ������� �������." +
                " � ��� ����� ������ ����� � ����� � �����." + ls +
                "������� �������� ������ � ��������� �����, " +
                "������� ���� � ����� � ������.";
        TEXT_INDEX_CHAR = "�!����� � �!������ �!�������� �!����� �!�����. " +
                "� �!� �!��� �!���� �!��� � �!��� � �!���." + ls +
                "�!����� �!������ �!���� � �!������� �!���, " +
                "�!����� �!�� � �!��� � �!����.";
        TEXT_PA = "�������� ��� ��������� �������� ��������, " +
                "������� ������� � �������.";
        TEXT_PO = "�������� ��� ��������� �������� ��������, " +
                "������� ������� � �������.";
        TEXT_SUBSTRING = "������� � �������� ���������� ������� �������." +
                " � ��� ������ ������ ������ � ������ � ������." + ls +
                "������� �������� ������ � ��������� ������, " +
                "������� ���� � ������ � ������.";
        TEXT_EXTRA_SYMBALS = "25 ������ ������� 2 ���� ����@@��� ���� ����� " +
                "1 �� ��� ������ ���� 3 ����." + ls +
                "25 different peo<<ple 2 Times Moved their h!ands up. 1 of" +
                " Them mo>ved his hand 3 times.";
        TEXT_WITHOUT_EXTRA_SYMBALS = "  ������ �������   ���� ���� ��� " +
                "���� �����   �� ��� ������ ����   ����." + ls +
                "  different peo ple   Times Moved their h ands up.   of" +
                " Them mo ved his hand   times.";
        TEXT_WITHOUT_CONSONANT = "������� � �������� ���������� ������� " +
                "�������. � ���  ������  �  � ." + ls +
                "������� �������� ������ � ��������� , " +
                "������� ���� �  � ������.";
    }

    @Test
    public void testReplaceCharInWord() {
        String actual = stringHandlingService.
                replaceCharInWord(TextData.REPLACE_CHAR_IN_WORD.getTextBefore(),
                        2, '!');
        assertEquals(actual, TextData.REPLACE_CHAR_IN_WORD.getTextAfter());
    }

    @Test
    public void testChangePAToPO() {
        String actual = stringHandlingService.changePAToPO(TEXT_PA);
        assertEquals(actual, TEXT_PO);
    }

    @Test
    public void testReplaceWordsToSubstring() {
        String actual = stringHandlingService.
                replaceWordsToSubstring(SOURCE_TEXT, 5, "������");
        assertEquals(actual, TEXT_SUBSTRING);
    }

    @Test
    public void testDeleteAllNotSpaceOrLetter() {
        String actual = stringHandlingService.
                deleteAllNotSpaceOrLetter(TEXT_EXTRA_SYMBALS);
        assertEquals(actual, TEXT_WITHOUT_EXTRA_SYMBALS);
    }

    @Test
    public void testDeleteConsonantWords() {
        String actual = stringHandlingService.
                deleteConsonantWords(SOURCE_TEXT, 5);
        assertEquals(actual, TEXT_WITHOUT_CONSONANT);
    }
}