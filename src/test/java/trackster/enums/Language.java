package trackster.enums;

public enum Language {
    ENGLISH(1),  //calls constructor with value 1
    UKRAINIAN(2);  //calls constructor with value 2

    private final int levelCode;

    Language(int levelCode) {
        this.levelCode = levelCode;
    }
    public int getProgrammerCode() {
        return this.levelCode;
    }
}
