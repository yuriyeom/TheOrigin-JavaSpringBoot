package dev.glassym.mission3_basic.entity;

import dev.glassym.mission3_basic.model.BoardDto;
import lombok.Builder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<PostEntity> getPostEntityList() {
        return postEntityList;
    }

    public static BoardEntityBuilder builder(BoardDto dto){
        return new BoardEntityBuilder()
                .id(dto.getId())
                .name(dto.getName());
    }

}