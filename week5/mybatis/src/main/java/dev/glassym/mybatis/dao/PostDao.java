package dev.glassym.mybatis.dao;

import com.fasterxml.jackson.databind.ext.SqlBlobSerializer;
import dev.glassym.mybatis.dto.PostDto;
import dev.glassym.mybatis.mapper.PostMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // 이 클래스가 데이터를 주고받기위해 존재하는 클래스다.
public class PostDao {
    // 실제로 매퍼를 사용해서 통신하는 클래스
    private final SqlSessionFactory sessionFactory;

    public PostDao(
            @Autowired SqlSessionFactory sessionFactory
    ){
        this.sessionFactory = sessionFactory;
    }

    public int creatPost(PostDto dto){
        try(SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.createPost(dto);
        }
    }

    public PostDto readPost(int id){
        try(SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.readPost(id);
        }
    }

    public List<PostDto> readPostAll(){
        try(SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.readPostAll();
        }
    }

    public int updatePost(PostDto dto){
        try(SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.updatePost(dto);
        }
    }

    public int deletePost(int id){
        try(SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.deletePost(id);
        }
    }

}
