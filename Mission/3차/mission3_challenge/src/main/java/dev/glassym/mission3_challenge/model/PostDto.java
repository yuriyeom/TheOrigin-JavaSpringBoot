package dev.glassym.mission3_challenge.model;

public class PostDto {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private int boardId;

    public PostDto(){
    }

    public PostDto(Long id, String title, String content, String writer, int boardId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.boardId = boardId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", boardId=" + boardId +
                '}';
    }
}
