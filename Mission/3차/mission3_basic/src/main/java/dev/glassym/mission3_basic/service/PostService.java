package dev.glassym.mission3_basic.service;

import dev.glassym.mission3_basic.entity.PostEntity;
import dev.glassym.mission3_basic.model.PostDto;
import dev.glassym.mission3_basic.repository.PostDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Service
public class PostService {
    private static final Logger logger = LoggerFactory.getLogger(PostService.class);
    private final PostDao postDao;

    public PostService(
            @Autowired PostDao postDao
    ){
        this.postDao = postDao;
    }

    public void createPost(int boardId, PostDto dto){
        this.postDao.createPost(boardId, dto);
    }

    public PostDto readPost(int boardId, int postid){
        PostEntity postEntity = this.postDao.readPost(boardId, postid);
        return new PostDto(
                postEntity.getId(),
                postEntity.getTitle(),
                postEntity.getContent(),
                postEntity.getUserEntity().getName(),
                postEntity.getBoardEntity() == null
                        ? 0 : Math.toIntExact(postEntity.getBoardEntity().getId())
        );
    }

    public List<PostDto> readPostAll(int boardId){
        Iterator<PostEntity> iterator = this.postDao.readPostAll();
        List<PostDto> postDtoList = new ArrayList<>();
        while(iterator.hasNext()){
            PostEntity postEntity = iterator.next();
            if(Objects.equals(postEntity.getBoardEntity().getId(), (long)boardId)) {
                postDtoList.add(new PostDto(
                        postEntity.getId(),
                        postEntity.getTitle(),
                        postEntity.getContent(),
                        postEntity.getUserEntity().getName(),
                        postEntity.getBoardEntity() == null
                                ? 0 : Math.toIntExact(postEntity.getBoardEntity().getId())
                ));
            }
        }
        return postDtoList;
    }

    public void updatePost(int boardId,  int postId, PostDto dto){
        this.postDao.updatePost(boardId, postId, dto);
    }

    public void deletePost(int boardId,int postId){
        this.postDao.deletePost(boardId, postId);
    }
}
