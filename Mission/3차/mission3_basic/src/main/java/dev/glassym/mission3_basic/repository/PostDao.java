package dev.glassym.mission3_basic.repository;

import dev.glassym.mission3_basic.entity.BoardEntity;
import dev.glassym.mission3_basic.entity.PostEntity;
import dev.glassym.mission3_basic.entity.UserEntity;
import dev.glassym.mission3_basic.model.PostDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;

@Repository
public class PostDao {
    private static final Logger logger = LoggerFactory.getLogger(PostDao.class);
    private final PostRepository postRepository;
    private final BoardDao boardDao;
    private final UserDao userDao;

    public PostDao(
            @Autowired PostRepository postRepository,
            @Autowired BoardDao boardDao,
            @Autowired UserDao userDao
    ){
        this.postRepository = postRepository;
        this.boardDao = boardDao;
        this.userDao = userDao;
    }

    public void createPost(int boardId, PostDto dto){
        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(dto.getTitle());
        postEntity.setContent(dto.getContent());

        UserEntity userEntity = this.userDao.readUserByWriter(dto.getWriter());
        postEntity.setUserEntity(userEntity);

        BoardEntity boardEntity = this.boardDao.readBoard(boardId);
        postEntity.setBoardEntity(boardEntity);

        this.postRepository.save(postEntity);
    }

    public PostEntity readPost(int boardId, int postId){
        Optional<PostEntity> postEntity = this.postRepository.findById((long) postId);
        if(!Objects.equals(postEntity.get().getBoardEntity().getId(), (long)boardId)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return postEntity.get();
    }

    public Iterator<PostEntity> readPostAll(){
        return this.postRepository.findAll().iterator();
    }

    public void updatePost(int boardId, int postId, PostDto dto){
        Optional<PostEntity> targetEntity = this.postRepository.findById((long) postId);
        if(targetEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if(!Objects.equals(targetEntity.get().getBoardEntity().getId(), (long) boardId)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        PostEntity postEntity = targetEntity.get();
        postEntity.setTitle(
                dto.getTitle() == null ? postEntity.getTitle() : dto.getTitle()
        );
        postEntity.setContent(
                dto.getContent() == null ? postEntity.getContent() : dto.getContent()
        );

        this.postRepository.save(postEntity);
    }

    public void deletePost(int boardId, int postId){
        Optional<PostEntity> targetEntity = this.postRepository.findById((long) postId);
        if(targetEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if(!Objects.equals(targetEntity.get().getBoardEntity().getId(), (long) boardId)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        this.postRepository.delete(targetEntity.get());
    }
}
