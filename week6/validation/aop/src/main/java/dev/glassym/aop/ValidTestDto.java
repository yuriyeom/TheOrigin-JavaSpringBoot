package dev.glassym.aop;

import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class ValidTestDto {
    @NotNull // 변수가 null이냐 아니냐
    private String notNullString;
    @NotEmpty // "" 허용x null은 아니지만 내용물이 없음 null이 아니면서, Object.size() > 0
    private String notEmptyString;
    @NotBlank // "  " 허용x
    private String notBlankString;

    @NotEmpty // null이 아니면서, Object.size() > 0
    private List<String> notEmptyStringList;

    public ValidTestDto() {
    }

    public ValidTestDto(String notNullString, String notEmptyString, String notBlankString, List<String> notEmptyStringList) {
        this.notNullString = notNullString;
        this.notEmptyString = notEmptyString;
        this.notBlankString = notBlankString;
        this.notEmptyStringList = notEmptyStringList;
    }

    public String getNotNullString() {
        return notNullString;
    }

    public void setNotNullString(String notNullString) {
        this.notNullString = notNullString;
    }

    public String getNotEmptyString() {
        return notEmptyString;
    }

    public void setNotEmptyString(String notEmptyString) {
        this.notEmptyString = notEmptyString;
    }

    public String getNotBlankString() {
        return notBlankString;
    }

    public void setNotBlankString(String notBlankString) {
        this.notBlankString = notBlankString;
    }

    public List<String> getNotEmptyStringList() {
        return notEmptyStringList;
    }

    public void setNotEmptyStringList(List<String> notEmptyStringList) {
        this.notEmptyStringList = notEmptyStringList;
    }

    @Override
    public String toString() {
        return "ValidTestDto{" +
                "notNullString='" + notNullString + '\'' +
                ", notEmptyString='" + notEmptyString + '\'' +
                ", notBlankString='" + notBlankString + '\'' +
                ", notEmptyStringList=" + notEmptyStringList +
                '}';
    }
}
