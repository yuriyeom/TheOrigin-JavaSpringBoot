package dev.glassym.mission3_basic.entity;

import lombok.Builder;
import javax.persistence.*;

@Entity
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @ManyToOne(
            targetEntity = BoardEntity.class,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "board_id")
    private BoardEntity boardEntity;

    @ManyToOne(
            targetEntity = UserEntity.class,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    public PostEntity() {
    }

    @Builder
    public PostEntity(Long id, String title, String content, BoardEntity boardEntity, UserEntity userEntity) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.boardEntity = boardEntity;
        this.userEntity = userEntity;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public BoardEntity getBoardEntity() {
        return boardEntity;
    }


}
