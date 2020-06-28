package by.kharitonov.day5.enumeration;

public enum TextData {
    REPLACE_CHAR_IN_WORD(1),
    REPLACE_PA_TO_PO(2),
    REPLACE_WORD_SUBSTRING(3),
    DELETE_NOT_LETTERS(4),
    DELETE_CONSONANT_WORDS(5);

    private final String textBefore;
    private final String textAfter;

    TextData(int index) {
        String ls = System.getProperty("line.separator");
        String general = "Однажды к пеликану неожиданно подошёл человек. " +
                "В это время котёнок сидел у птицы в клюве." + ls +
                "Once a man suddenly approached a pelican. At this time, " +
                "the kitten was sitting by the bird in its beak.";
        switch (index) {
            case 1:
                textBefore = general;
                textAfter = "О!нажды к п!ликану н!ожиданно п!дошёл ч!ловек. " +
                        "В э!о в!емя к!тёнок с!дел у п!ицы в к!юве." + ls +
                        "O!ce a m!n s!ddenly a!proached a p!lican. A! t!is" +
                        " t!me, t!e k!tten w!s s!tting b! t!e" +
                        " b!rd i! i!s b!ak.";
                break;
            case 2:
                textBefore = "РАботяга был недоволен РАзмером зарплаты, " +
                        "поэтому работал в полсилы.";
                textAfter = "РОботяга был недоволен РОзмером зарплаты, " +
                        "поэтому работал в полсилы.";
                break;
            case 3:
                textBefore = general;
                textAfter = "ЗАМЕНА к пеликану неожиданно ЗАМЕНА ЗАМЕНА. " +
                        "В это время ЗАМЕНА сидел у птицы в клюве." + ls +
                        "Once a man suddenly approached a ЗАМЕНА. At this time, " +
                        "the kitten was ЗАМЕНА by the bird in its beak.";
                break;
            case 4:
                textBefore = "25 Разных человек 2 раза подн@@яли руки вверх. " +
                        "1 из них Поднял руки 3 раза." + ls +
                        "25 different peo<<ple 2 Times Moved their h!ands up." +
                        " 1 of Them mo>ved his hand 3 times.";
                textAfter = "  Разных человек   раза подн яли " +
                        "руки вверх    из них Поднял руки   раза " + ls +
                        "  different peo ple   Times Moved their h ands up" +
                        "    of Them mo ved his hand   times ";
                break;
            case 5:
                textBefore = general;
                textAfter = "Однажды к пеликану неожиданно  . " +
                        "В это время  сидел у птицы в клюве." + ls +
                        "Once a man suddenly approached a . At this time, " +
                        "the kitten was  by the bird in its beak.";
                break;
            default:
                textBefore = "";
                textAfter = "";
        }
    }

    public String getTextBefore() {
        return textBefore;
    }

    public String getTextAfter() {
        return textAfter;
    }
}
