package dev.glassym.exception;

public class BoardDto {
    private String name;

    public BoardDto() {
    }

    public BoardDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
