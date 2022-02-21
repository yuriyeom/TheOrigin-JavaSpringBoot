package dev.glassym.mission2_basic.post;

import java.util.List;

public interface PostService {
    void createPost(PostDto postDto);
    List<PostDto> readPostAll();
    PostDto readPost(int id);
    void updatePost(int id, PostDto postDto);
    void deletePost(int id, String password);
}
