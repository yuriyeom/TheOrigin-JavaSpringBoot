package dev.glassym.mission2_basic.post;

import dev.glassym.mission2_basic.board.BoardDto;
import dev.glassym.mission2_basic.board.BoardRepository;
import dev.glassym.mission2_basic.board.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PostServiceSimple implements PostService{

    private static final Logger logger = LoggerFactory.getLogger(PostServiceSimple.class);
    private final BoardRepository boardRepository;
    private final PostRepository postRepository;

    public PostServiceSimple(
            @Autowired PostRepository postRepository,
            @Autowired BoardRepository boardRepository
    ){
        this.boardRepository = boardRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void createPost(PostDto postDto) {
        this.postRepository.save(postDto);
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
