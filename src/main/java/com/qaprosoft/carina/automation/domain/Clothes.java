package com.qaprosoft.carina.automation.domain;

public enum Clothes {

    DRESSES("Dresses"),
    WOMEN("Women"),
    T_SHIRT("T_shirt");

    private String name;

    Clothes(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
