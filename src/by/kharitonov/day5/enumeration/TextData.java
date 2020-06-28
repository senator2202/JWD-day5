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
                textBefore = "Однажды к пеликану неожиданно подошёл человек." +
                        " В это время котёнок сидел у птицы в клюве." + ls +
                        "Пеликан затолкал котёнка в глоточный мешок, " +
                        "сомкнул клюв и взмыл в воздух.";
                textAfter = "О!нажды к п!ликану н!ожиданно п!дошёл ч!ловек. " +
                        "В э!о в!емя к!тёнок с!дел у п!ицы в к!юве." + ls +
                        "П!ликан з!толкал к!тёнка в г!оточный м!шок, " +
                        "с!мкнул к!юв и в!мыл в в!здух.";
                break;
            case 2:
                textBefore = "РАботяга был недоволен РАзмером зарплаты, " +
                        "поэтому работал в полсилы.";
                textAfter = "РОботяга был недоволен РОзмером зарплаты, " +
                        "поэтому работал в полсилы.";
                break;
            case 3:
                textBefore = "Однажды к пеликану неожиданно подошёл человек." +
                        " В это время котёнок сидел у птицы в клюве." + ls +
                        "Пеликан затолкал котёнка в глоточный мешок, " +
                        "сомкнул клюв и взмыл в воздух.";
                textAfter = "Однажды к пеликану неожиданно подошёл человек." +
                        " В это ЗАМЕНА котёнок ЗАМЕНА у ЗАМЕНА в ЗАМЕНА." + ls +
                        "Пеликан затолкал котёнка в глоточный ЗАМЕНА, " +
                        "сомкнул клюв и ЗАМЕНА в воздух.";
                break;
            case 4:
                textBefore = "25 Разных человек 2 раза подн@@яли руки вверх " +
                        "1 из них Поднял руки 3 раза." + ls +
                        "25 different peo<<ple 2 Times Moved their h!ands up. 1 of" +
                        " Them mo>ved his hand 3 times.";
                textAfter = "  Разных человек   раза подн яли " +
                        "руки вверх   из них Поднял руки   раза." + ls +
                        "  different peo ple   Times Moved their h ands up.   of" +
                        " Them mo ved his hand   times.";
                break;
            case 5:
                textBefore = "Однажды к пеликану неожиданно подошёл человек." +
                        " В это время котёнок сидел у птицы в клюве." + ls +
                        "Пеликан затолкал котёнка в глоточный мешок, " +
                        "сомкнул клюв и взмыл в воздух.";
                textAfter = "Однажды к пеликану неожиданно подошёл " +
                        "человек. В это  котёнок  у  в ." + ls +
                        "Пеликан затолкал котёнка в глоточный , " +
                        "сомкнул клюв и  в воздух.";
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
