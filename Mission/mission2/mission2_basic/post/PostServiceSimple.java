package dev.glassym.mission2_basic.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PostServiceSimple implements PostService{

    private static final Logger logger = LoggerFactory.getLogger(PostServiceSimple.class);
    private final PostRepository postRepository;

    public PostServiceSimple(
            @Autowired PostRepository postRepository
    ){
        this.postRepository = postRepository;
    }

    @Override
    public void createPost(PostDto postDto) {
        // TODO
        if(!this.postRepository.save(postDto)){
            throw new RuntimeException("save failed");
        }
    }

    @Override
    public List<PostDto> readPostAll() {
        return this.postRepository.findAll();
    }

    @Override
    public PostDto readPost(int id) {
        return this.postRepository.findById(id);
    }

    @Override
    public void updatePost(int id, PostDto postDto) {
        this.postRepository.update(id, postDto);
    }

    @Override
    public void deletePost(int id, String password) {
        if(this.postRepository.findById(id).getPassword().equals(password)){
            this.postRepository.delete(id);
        }
    }
}
