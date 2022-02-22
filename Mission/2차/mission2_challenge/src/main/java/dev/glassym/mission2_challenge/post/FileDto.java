package dev.glassym.mission2_challenge.post;

public class FileDto {

    private int id;
    private String postTitle;
    private String originalFileName;

    public FileDto(int id, String postTitle, String originalFileName) {
        this.id = id;
        this.postTitle = postTitle;
        this.originalFileName = originalFileName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostId() {
        return postTitle;
    }

    public void setPostId(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    @Override
    public String toString() {
        return "FileDto{" +
                "id=" + id +
                ", postTitle=" + postTitle +
                ", originalFileName='" + originalFileName + '\'' +
                '}';
    }
}
