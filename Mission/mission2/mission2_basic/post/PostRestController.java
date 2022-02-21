package dev.glassym.mission2_basic.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("post")
public class PostRestController {
    private static final Logger logger = LoggerFactory.getLogger(PostRestController.class);
    private final PostService postService;

    public PostRestController(
            @Autowired PostService postService
    ){
        this.postService = postService;
    }

    @PostMapping()
    public void createPost(@RequestBody PostDto postDto){
        logger.info("create post");
        logger.info(postDto.toString());
        this.postService.createPost(postDto);
    }

    @GetMapping()
    public List<PostDto> readPostAll(){
        logger.info("read post all");
        return this.postService.readPostAll();
    }

    @GetMapping("{id}") // http://localhost:8080/post/2
    public PostDto readPost(@PathVariable int id){ // 2번이면 id가 아니라 arraylist인덱스
        logger.info("read post one");
        return this.postService.readPost(id);
    }
//
//    @GetMapping("{id}") // http://localhost:8080/post/2
//    public PostDto readPost(@PathVariable int id){ // 2번이면 id가 아니라 arraylist인덱스
//        logger.info("read post one");
//        List<PostDto> list = this.postService.readPostAll();
//        for(PostDto post : list){
//            if(post.getId() == id)  return post;
//        }
//    }

    @PutMapping("{id}")
    public void updatePost(
            @PathVariable int id,
            @RequestBody PostDto postDto){
        logger.info("update post");
        logger.info("id : " + id + " content : " + postDto.toString());
        this.postService.updatePost(id, postDto);
    }

    @DeleteMapping("{id}")
    public void deletePost(
            @PathVariable int id,
            @RequestBody Map<String, String> param){
        logger.info("delete post");
        String password = param.get("password");
        logger.info("입력하신 비밀번호 : " + password);
        this.postService.deletePost(id, password);
    }
}
