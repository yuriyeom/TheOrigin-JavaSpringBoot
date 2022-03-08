package dev.glassym.mission3_challenge.entity;

public enum Category {
    A("A"),
    B("B"),
    C("C");

    private final String value;

    Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
