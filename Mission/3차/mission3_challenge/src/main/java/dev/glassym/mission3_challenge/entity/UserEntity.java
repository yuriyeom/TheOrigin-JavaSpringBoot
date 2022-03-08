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

    @Enumerated(EnumType.STRING)
    private Auth auth; // 일반 사용자, 상점 주인

    @OneToMany(
            targetEntity = ShopEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "userEntity"
    )
    private List<ShopEntity> shopEntityList = new ArrayList<>();

    @ManyToOne(
            targetEntity = AreaEntity.class,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "area_id")
    private AreaEntity areaEntity;

    @OneToMany(
            targetEntity = PostEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "userEntity"
    )
    private List<PostEntity> postEntityList = new ArrayList<>();

    public UserEntity() {
    }

    @Builder
    public UserEntity(Long id, String name, String password, Auth auth) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.auth = auth;
    }

    @Builder
    public UserEntity(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
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

    public List<PostEntity> getPostEntityList() {
        return postEntityList;
    }

    public Auth getAuth() {
        return auth;
    }

    public AreaEntity getAreaEntity() {
        return areaEntity;
    }
}