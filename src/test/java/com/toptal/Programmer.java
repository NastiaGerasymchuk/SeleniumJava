package com.toptal;

public enum Programmer {
    DEVELOPER(1),  //calls constructor with value 3
    Designer(2),  //calls constructor with value 2
    FINANCE_EXPERT(3),//calls constructor with value 1
    PROJECT_MANAGER(4),
    PRODUCT_MANAGER(5);
    private final int levelCode;

    private Programmer(int levelCode) {
        this.levelCode = levelCode;
    }
    public int getProgrammerCode() {
        return this.levelCode;
    }
}
