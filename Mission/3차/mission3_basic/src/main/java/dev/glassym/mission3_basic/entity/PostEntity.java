package dev.glassym.mission3_basic.entity;

import dev.glassym.mission3_basic.model.PostDto;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setBoardEntity(BoardEntity boardEntity) {
        this.boardEntity = boardEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

}
