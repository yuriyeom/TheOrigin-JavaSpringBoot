package dev.glassym.mission3_challenge.entity;

import dev.glassym.mission3_challenge.model.BoardDto;
import lombok.Builder;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "Board")
@Entity
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(
            targetEntity = PostEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "boardEntity"
    )
    private List<PostEntity> postEntityList = new ArrayList<>();

    public BoardEntity() {
    }

    @Builder
    public BoardEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Builder
    public BoardEntity(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}