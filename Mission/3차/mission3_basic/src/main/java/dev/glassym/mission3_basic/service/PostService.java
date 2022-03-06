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

@Service
public class PostService {
    private static final Logger logger = LoggerFactory.getLogger(PostService.class);
    private final PostDao postDao;

    public PostService(
            @Autowired PostDao postDao
    ){
        this.postDao = postDao;
    }

    public void createPost(PostDto dto){
        this.postDao.createPost(dto);
    }

    public PostDto readPost(int id){
        PostEntity postEntity = this.postDao.readPost(id);
        return new PostDto(
                postEntity.getId(),
                postEntity.getTitle(),
                postEntity.getContent(),
                postEntity.getWriter(),
                postEntity.getBoardEntity() == null
                        ? 0 : Math.toIntExact(postEntity.getBoardEntity().getId())
        );
    }

    public List<PostDto> readPostAll(){
        Iterator<PostEntity> iterator = this.postDao.readPostAll();
        List<PostDto> postDtoList = new ArrayList<>();
        while(iterator.hasNext()){
            PostEntity postEntity = iterator.next();
            postDtoList.add(new PostDto(
                    postEntity.getId(),
                    postEntity.getTitle(),
                    postEntity.getContent(),
                    postEntity.getWriter(),
                    postEntity.getBoardEntity() == null
                            ? 0 : Math.toIntExact(postEntity.getBoardEntity().getId())
            ));
        }
        return postDtoList;
    }

    public void updatePost(int id, PostDto dto){
        this.postDao.updatePost(id, dto);
    }

    public void deletePost(int id){
        this.postDao.deletePost(id);
    }
}
