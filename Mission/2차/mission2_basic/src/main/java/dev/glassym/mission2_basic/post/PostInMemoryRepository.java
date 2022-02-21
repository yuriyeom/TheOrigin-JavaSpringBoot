package dev.glassym.mission2_basic.post;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostInMemoryRepository implements PostRepository{
    private final List<PostDto> postList;

    public PostInMemoryRepository(){
        this.postList = new ArrayList<>();
    }

    @Override
    public boolean save(PostDto postDto) {
        return this.postList.add(postDto);
    }

    @Override
    public List<PostDto> findAll() {
        return this.postList;
    }

    @Override
    public PostDto findById(int id) {
        return this.postList.get(id);
    }

    @Override
    public boolean update(int id, PostDto postDto) {
        PostDto targetPost = this.postList.get(id);
        if(postDto.getTitle() != null){
            targetPost.setTitle(postDto.getTitle());
        }
        if(postDto.getContent() != null){
            targetPost.setContent(postDto.getContent());
        }

        this.postList.set(id, targetPost);
        return true;
    }

    @Override
    public boolean delete(int id) {
        this.postList.remove(id);
        return true;
    }
}
