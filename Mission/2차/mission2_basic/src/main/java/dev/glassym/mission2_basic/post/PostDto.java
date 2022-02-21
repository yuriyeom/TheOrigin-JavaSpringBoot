package dev.glassym.mission2_basic.post;

public class PostDto {
    private int id;
    private int boardId;
    private String title;
    private String content;
    private String writer;
    private String password;

    public PostDto(){
    }

    public PostDto(int id, int boardId, String title, String content, String writer, String password){
        this.id = id;
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "id=" + id +
                ", boardId=" + boardId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
