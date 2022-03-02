package dev.glassym.jpa;

import dev.glassym.jpa.entity.BoardEntity;
import dev.glassym.jpa.entity.PostEntity;
import dev.glassym.jpa.repository.BoardRepository;
import dev.glassym.jpa.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestComponent {
    public TestComponent(
            @Autowired BoardRepository boardRepository,
            @Autowired PostRepository postRepository
            ){
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setName("new board");
        BoardEntity newBoardEntity = boardRepository.save(boardEntity);
        System.out.println(newBoardEntity.getName());

        PostEntity postEntity = new PostEntity();
        postEntity.setTitle("hello ORM");
        postEntity.setContent("This Entity is created by hibernate!");
        postEntity.setWriter("glassym");
        postEntity.setBoardEntity(newBoardEntity);

        PostEntity newPostEntity = postRepository.save(postEntity);
        System.out.println(postRepository.findAllByWriter("glassym").size());
    }
}
