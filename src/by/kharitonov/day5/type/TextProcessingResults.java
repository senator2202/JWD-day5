package by.kharitonov.day5.type;

public class TextProcessingResults {
    public static final String SOURCE_TEXT;
    public static final String REPLACED_CHAR_IN_WORDS;
    public static final String REPLACED_ONE_TO_ANOTHER;
    public static final String REPLACED_WORD_TO_SUBSTRING;
    public static final String DELETED_NOT_LETTERS;
    public static final String DELETED_CONSONANT_WORDS;

    static {
        String ls = System.getProperty("line.separator");
        SOURCE_TEXT = "������� � �������� ���������� ������� �������. " +
                "� ��� ����� ������ ����� � ����� � �����." + ls +
                "Once a man suddenly approached a pelican. " +
                "At this time, the kitten was sitting by " +
                "the bird in its beak." + ls +
                "������25�� ��� ����<<����� �������� �����_���, " +
                "������� ������� � ���322����.";
        REPLACED_CHAR_IN_WORDS = "�!����� � �!������ �!�������� �!����� " +
                "�!�����. � �!� �!��� �!���� �!��� � �!��� � �!���." + ls +
                "O!ce a m!n s!ddenly a!proached a p!lican. " +
                "A! t!is t!me, t!e k!tten w!s s!tting b! " +
                "t!e b!rd i! i!s b!ak." + ls +
                "�!����25�� �!� �!��<<����� �!������ �!���_���, " +
                "�!����� �!����� � �!�322����.";
        REPLACED_ONE_TO_ANOTHER = "������� � �������� ���������� ������� " +
                "�������. � ��� ����� ������ ����� � ����� � �����." + ls +
                "Once a man suddenly approached a pelican. " +
                "At this time, the kitten was sitting by " +
                "the bird in its beak." + ls +
                "������25�� ��� ����<<����� �������� �����_���, " +
                "������� ������� � ���322����.";
        REPLACED_WORD_TO_SUBSTRING = "������ � �������� ���������� ������ " +
                "������. � ��� ����� ������ ����� � ����� � �����." + ls +
                "Once a man suddenly approached a ������. " +
                "At this time, the kitten was ������ by " +
                "the bird in its beak." + ls +
                "������25�� ��� ����<<����� �������� �����_���, " +
                "������ ������ � ���322����.";
        DELETED_NOT_LETTERS = "������� � �������� ���������� ������� " +
                "�������  � ��� ����� ������ ����� � ����� � ����� " +
                "Once a man suddenly approached a pelican  " +
                "At this time  the kitten was sitting by " +
                "the bird in its beak " +
                "������ �� ��� ���� ����� �������� ����� ���  " +
                "������� ������� � ��� ���� ";
        DELETED_CONSONANT_WORDS = "������� � �������� ����������  . " +
                "� ��� �����  ����� � ����� � �����." + ls +
                "Once a man suddenly approached a . " +
                "At this time, the kitten was  by " +
                "the bird in its beak." + ls +
                "������25�� ��� ����<<����� �������� �����_���, " +
                "  � ���322����.";
    }

    private TextProcessingResults() {
    }
}
