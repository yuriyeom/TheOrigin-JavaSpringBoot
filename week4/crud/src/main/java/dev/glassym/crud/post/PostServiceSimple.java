package dev.glassym.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceSimple implements PostService{

    private static final Logger logger = LoggerFactory.getLogger(PostServiceSimple.class);
    private final PostRepository postRepository; // 인터페이스로 가져온다.

    public PostServiceSimple(
            @Autowired PostRepository postRepository // ioc컨테이너가 이렇게 인터페이스를 요구해도 만족되는 우선적인 구현체를 가져온다. 지금은 inmemory 클래스
    ){
        this.postRepository = postRepository;
    }

    @Override
    public void createPost(PostDto dto) {
        // TODO
        if(!this.postRepository.save(dto)){
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
    public void updatePost(int id, PostDto dto) {
        this.postRepository.update(id, dto);
    }

    @Override
    public void deletePost(int id) {
        this.postRepository.delete(id);
    }
}
