package dev.glassym.mission3_basic.model;

public class UserDto {
    private Long id;
    private String name;
    private String password;

    public UserDto() {
    }

    public UserDto(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", email='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
