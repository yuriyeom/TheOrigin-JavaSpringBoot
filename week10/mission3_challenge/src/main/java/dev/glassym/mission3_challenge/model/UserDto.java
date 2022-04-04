package dev.glassym.mission3_challenge.model;

import dev.glassym.mission3_challenge.entity.AreaEntity;
import dev.glassym.mission3_challenge.entity.UserEntity;

public class UserDto {
    private Long id;
    private String name;
    private String password;
    private Boolean isShopOwner;
    private Long residence;

    public UserDto() {
    }

    public UserDto(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public UserDto(Long id, String name, String password, Boolean isShopOwner, Long residence) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.isShopOwner = isShopOwner;
        this.residence = residence;
    }

    public UserDto(UserEntity userEntity){
        this.id = userEntity.getId();
        this.name = userEntity.getName();
        this.password = userEntity.getPassword();
        this.residence = userEntity.getResidence().getId();
        this.isShopOwner = userEntity.getShopOwner();
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

    public Boolean getShopOwner() {
        return isShopOwner;
    }

    public void setShopOwner(Boolean shopOwner) {
        isShopOwner = shopOwner;
    }

    public Long getResidence() {
        return residence;
    }

    public void setResidence(Long residence) {
        this.residence = residence;
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
