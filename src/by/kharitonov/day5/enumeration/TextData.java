package by.kharitonov.day5.enumeration;

public enum TextData {
    REPLACE_CHAR_IN_WORD(1),
    REPLACE_PA_TO_PO(2),
    REPLACE_WORD_SUBSTRING(3),
    DELETE_NOT_LETTERS(4),
    DELETE_CONSONANT_WORDS(5);

    private String textBefore;
    private String textAfter;

    TextData(int index) {
        String ls = System.getProperty("line.separator");
        switch (index) {
            case 1:
                textBefore = "������� � �������� ���������� ������� �������." +
                        " � ��� ����� ������ ����� � ����� � �����." + ls +
                        "������� �������� ������ � ��������� �����, " +
                        "������� ���� � ����� � ������.";
                textAfter = "�!����� � �!������ �!�������� �!����� �!�����. " +
                        "� �!� �!��� �!���� �!��� � �!��� � �!���." + ls +
                        "�!����� �!������ �!���� � �!������� �!���, " +
                        "�!����� �!�� � �!��� � �!����.";
                break;
            case 2:
                textBefore = "�������� ��� ��������� �������� ��������, " +
                        "������� ������� � �������.";
                textAfter = "�������� ��� ��������� �������� ��������, " +
                        "������� ������� � �������.";
                break;
            case 3:
                textBefore = "������� � �������� ���������� ������� �������." +
                        " � ��� ����� ������ ����� � ����� � �����." + ls +
                        "������� �������� ������ � ��������� �����, " +
                        "������� ���� � ����� � ������.";
                textAfter = "������� � �������� ���������� ������� �������." +
                        " � ��� ������ ������ ������ � ������ � ������." + ls +
                        "������� �������� ������ � ��������� ������, " +
                        "������� ���� � ������ � ������.";
                break;
            case 4:
                textBefore = "25 ������ ������� 2 ���� ����@@��� ���� ����� " +
                        "1 �� ��� ������ ���� 3 ����." + ls +
                        "25 different peo<<ple 2 Times Moved their h!ands up. 1 of" +
                        " Them mo>ved his hand 3 times.";
                textAfter = "  ������ �������   ���� ���� ��� " +
                        "���� �����   �� ��� ������ ����   ����." + ls +
                        "  different peo ple   Times Moved their h ands up.   of" +
                        " Them mo ved his hand   times.";
                break;
            case 5:
                textBefore = "������� � �������� ���������� ������� �������." +
                        " � ��� ����� ������ ����� � ����� � �����." + ls +
                        "������� �������� ������ � ��������� �����, " +
                        "������� ���� � ����� � ������.";
                textAfter = "������� � �������� ���������� ������� " +
                        "�������. � ���  ������  �  � ." + ls +
                        "������� �������� ������ � ��������� , " +
                        "������� ���� �  � ������.";
                break;
        }
    }

    public String getTextBefore() {
        return textBefore;
    }

    public String getTextAfter() {
        return textAfter;
    }
}
