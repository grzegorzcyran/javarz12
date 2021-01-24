package edu.grcy.sda.java8.streams;

public enum Gender {
    WOMAN(1, "K", "W", "kobieta"),
    MAN(2, "M", "M", "mężczyzna");

    private int index;
    private String shortcutPl;
    private String shortcutEn;
    private String translationPl;

    Gender(int index, String shortcutPl, String shortcutEn, String translationPl) {
        this.index = index;
        this.shortcutPl = shortcutPl;
        this.shortcutEn = shortcutEn;
        this.translationPl = translationPl;
    }

    public int getIndex() {
        return index;
    }

    public String getShortcutPl() {
        return shortcutPl;
    }

    public String getShortcutEn() {
        return shortcutEn;
    }

    public String getTranslationPl() {
        return translationPl;
    }

    //znajdziemy płeć na podstawie przekazanego skrótu
    //czyli do metody przekażemy "M" a zwróci nam element MAN
    public static Gender getByShortcutPl(String shortcutPl) {
        for (Gender gender : Gender.values()) {
            if (shortcutPl.equals(gender.getShortcutPl())) {
                return gender;
            }
        }
        return null;
    }
}
