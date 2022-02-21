package dev.glassym.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
//@RequestMapping("post")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    // final 선언을 했는데 초기화 안돼서 빨간줄
//    private final List<PostDto> postList;
    private final PostService postService;

    public PostController(
            @Autowired PostService postService
    ){
//        postList = new ArrayList<>();
        this.postService = postService;
    }

    @PostMapping("create")
    public void createPost(@RequestBody PostDto postDto){
        logger.info(postDto.toString());
        this.postService.createPost(postDto);
    }

    @GetMapping("read-all")
    public List<PostDto> readPostAll(){
        logger.info("in read all");
        return this.postService.readPostAll();
    }

    @GetMapping("read-one")
    public PostDto readPostOne(@RequestParam("id") int id){
        logger.info("in read one");
        return this.postService.readPost(id);
    }

    @PostMapping("update")
    public void updatePost(@RequestParam("id") int id, @RequestBody PostDto postDto){
//        PostDto targetPost = this.postService.readPost(id);
        logger.info("target id: " + id);
        logger.info("update content" + postDto);
        this.postService.updatePost(id, postDto);
//        // writer는 바꿀 수 없다고 가정
//        if(postDto.getTitle() != null){
//            targetPost.setTitle(postDto.getTitle());
//        }
//        if(postDto.getContent() != null){
//            targetPost.setContent(postDto.getContent());
//        }
//        // 왜 검사를 하냐
//        // 받아온 postDto에 title이나 content가 비어있다면
//        // 빈 그대로 다시 업데이트되기 때문에

//        this.postList.set(id, targetPost);


    }

    @DeleteMapping("delete")
    public void deletePost(@RequestParam("id") int id){
        this.postService.deletePost(id);
    }

}
