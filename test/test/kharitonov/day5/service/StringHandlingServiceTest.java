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
        SOURCE_TEXT = "Однажды к пеликану неожиданно подошёл человек." +
                " В это время котёнок сидел у птицы в клюве." + ls +
                "Пеликан затолкал котёнка в глоточный мешок, " +
                "сомкнул клюв и взмыл в воздух.";
        TEXT_INDEX_CHAR = "О!нажды к п!ликану н!ожиданно п!дошёл ч!ловек. " +
                "В э!о в!емя к!тёнок с!дел у п!ицы в к!юве." + ls +
                "П!ликан з!толкал к!тёнка в г!оточный м!шок, " +
                "с!мкнул к!юв и в!мыл в в!здух.";
        TEXT_PA = "РАботяга был недоволен РАзмером зарплаты, " +
                "поэтому работал в полсилы.";
        TEXT_PO = "РОботяга был недоволен РОзмером зарплаты, " +
                "поэтому работал в полсилы.";
        TEXT_SUBSTRING = "Однажды к пеликану неожиданно подошёл человек." +
                " В это ЗАМЕНА котёнок ЗАМЕНА у ЗАМЕНА в ЗАМЕНА." + ls +
                "Пеликан затолкал котёнка в глоточный ЗАМЕНА, " +
                "сомкнул клюв и ЗАМЕНА в воздух.";
        TEXT_EXTRA_SYMBALS = "25 Разных человек 2 раза подн@@яли руки вверх " +
                "1 из них Поднял руки 3 раза." + ls +
                "25 different peo<<ple 2 Times Moved their h!ands up. 1 of" +
                " Them mo>ved his hand 3 times.";
        TEXT_WITHOUT_EXTRA_SYMBALS = "  Разных человек   раза подн яли " +
                "руки вверх   из них Поднял руки   раза." + ls +
                "  different peo ple   Times Moved their h ands up.   of" +
                " Them mo ved his hand   times.";
        TEXT_WITHOUT_CONSONANT = "Однажды к пеликану неожиданно подошёл " +
                "человек. В это  котёнок  у  в ." + ls +
                "Пеликан затолкал котёнка в глоточный , " +
                "сомкнул клюв и  в воздух.";
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
                replaceWordsToSubstring(SOURCE_TEXT, 5, "ЗАМЕНА");
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