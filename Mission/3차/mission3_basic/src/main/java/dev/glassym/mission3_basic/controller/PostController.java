package dev.glassym.mission3_basic.controller;

import dev.glassym.mission3_basic.model.PostDto;
import dev.glassym.mission3_basic.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("board/{boardId}/post")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;

    public PostController(
            @Autowired PostService postService
    ){
        this.postService = postService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(
            @PathVariable("boardId") int boardId,
            @RequestBody PostDto dto){
        this.postService.createPost(boardId, dto);
    }

    @GetMapping("{postId}")
    public PostDto readPost(
            @PathVariable("boardId") int boardtId,
            @PathVariable("postId") int postId
    ){
        return this.postService.readPost(boardtId, postId);
    }

    @GetMapping()
    public List<PostDto> readPostAll(
            @PathVariable("boardId") int boardId
    ){
        return this.postService.readPostAll(boardId);
    }

    @PutMapping("{postId}")
    public void updatePost(
            @PathVariable("boardId") int boardId,
            @PathVariable("postId") int postId,
            @RequestBody PostDto dto
    ){
        this.postService.updatePost(boardId, postId, dto);
    }

    @DeleteMapping("{postId}")
    public void deletePost(
            @PathVariable("boardId") int boardId,
            @PathVariable("postId") int postId
    ){
        this.postService.deletePost(boardId, postId);
    }
}
