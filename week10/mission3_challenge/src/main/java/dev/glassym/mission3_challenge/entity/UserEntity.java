package dev.glassym.mission3_challenge.entity;

import lombok.Builder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "User")
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String password;

    @ManyToOne(
            targetEntity = AreaEntity.class,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "area_id")
    private AreaEntity residence;

    private Boolean isShopOwner;


    public UserEntity() {
    }

    @Builder
    public UserEntity(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public UserEntity(Long id, String name, String password, AreaEntity residence, Boolean isShopOwner) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.residence = residence;
        this.isShopOwner = isShopOwner;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public AreaEntity getResidence() {
        return residence;
    }

    public Boolean getShopOwner() {
        return isShopOwner;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setResidence(AreaEntity residence) {
        this.residence = residence;
    }

    public void setShopOwner(Boolean shopOwner) {
        isShopOwner = shopOwner;
    }
}