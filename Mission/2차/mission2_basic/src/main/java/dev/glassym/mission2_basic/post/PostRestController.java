package dev.glassym.mission2_basic.post;

import dev.glassym.mission2_basic.board.BoardRestController;
import dev.glassym.mission2_basic.board.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("board")
public class PostRestController {
    private static final Logger logger = LoggerFactory.getLogger(PostRestController.class);
    private final PostService postService;

    public PostRestController(
            @Autowired PostService postService
    ){
        this.postService = postService;
    }

    // POST http://localhost:8080/board/0/post
    @PostMapping("/{boardId}/post")
    public void createPost(
            @PathVariable int boardId,
            @RequestBody PostDto postDto){
        logger.info("create post");
        logger.info(postDto.toString());
        postDto.setBoardId(boardId);
        this.postService.createPost(postDto);
    }

    // GET http://localhost:8080/board/0/post
    @GetMapping("{boardId}/post")
    public List<PostDto> readPostByBoard(@PathVariable int boardId){
        List<PostDto> result = new ArrayList<>();
        List<PostDto> postDtoList = this.postService.readPostAll();
        for(PostDto post: postDtoList){
            if(post.getBoardId() == boardId){
                result.add(post);
            }
        }
        return result;
    }

    // GET http://localhost:8080/board/all/post
    @GetMapping("all/post")
    public List<PostDto> readPostAll(){
        logger.info("read post all");
        return this.postService.readPostAll();
    }


    // GET http://localhost:8080/board/all/post/0
    @GetMapping("all/post/{id}")
    public PostDto readPost(@PathVariable int id){
        logger.info("read post one");
        return this.postService.readPost(id);
    }

    // PUT http://localhost:8080/board/all/post/0
    @PutMapping("all/post/{id}")
    public void updatePost(
            @PathVariable int id,
            @RequestBody PostDto postDto){
        logger.info("update post");
//        logger.info("id : " + id + " content : " + postDto.toString());
        this.postService.updatePost(id, postDto);
    }

    // DELETE http://localhost:8080/board/all/post/0
    @DeleteMapping("all/post/{id}")
    public void deletePost(
            @PathVariable int id,
            @RequestBody Map<String, String> param){
        logger.info("delete post");
        String password = param.get("password");
        logger.info("입력하신 비밀번호 : " + password);
        this.postService.deletePost(id, password);
    }
}
