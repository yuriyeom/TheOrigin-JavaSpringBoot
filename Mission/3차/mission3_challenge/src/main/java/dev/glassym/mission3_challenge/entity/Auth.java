package dev.glassym.mission3_challenge.entity;

public enum Auth {
    USER("ROLE_USER"),
    OWNER("ROLE_OWNER");

    private final String value;

    Auth(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
