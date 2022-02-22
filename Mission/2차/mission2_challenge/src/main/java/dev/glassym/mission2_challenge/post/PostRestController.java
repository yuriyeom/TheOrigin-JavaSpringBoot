package dev.glassym.mission2_challenge.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public void createImgPost(
            @RequestPart(value = "file", required = false) List<MultipartFile> files,
            @RequestPart("postDto") PostDto postDto
    ) throws IOException {
        logger.info(postDto.toString());
        if(postDto.getFiles() == null){
            postDto.setFiles(new ArrayList<>());
        }
        logger.info(postDto.toString());
        postService.createPost(postDto, files);
    }

    // read
    // http://localhost:8080/post 게시글에 대한 정보를 볼거야
    // GET /post
    @GetMapping()
    public List<PostDto> readPostAll(){
        logger.info("in read post all");
        return this.postService.readPostAll();
    }

    // read one
    // GET /post/0/
    @GetMapping("{id}") // 파일이 나열됐으면 더블클릭해서 한 파일을 연다.
    public PostDto readPost(@PathVariable int id){ // query 쓰지 않고 path를 쓴다.
        logger.info("in read post");
        return this.postService.readPost(id);
    }

    // PUT /post/0/
    @PutMapping("{id}") // 대체. 있는 데이터에 다시 넣어주세요
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePost(
            @PathVariable("id") int id,
            @RequestBody PostDto postDto // 어떤식으로 업데이트할지를 바디로 보낸다.
    ){
        logger.info("target id: " + id);
        logger.info("update content" + postDto);
        this.postService.updatePost(id, postDto);
    }

    // DELETE /post/0
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(
            @PathVariable("id") int id
    ){
        this.postService.deletePost(id);
    }

    // POST /post
    // GET /post/0/
    // GET /post
    // PUT /post/0/
    // DELETE /post/0

    // 어떤 작업을 하고 싶은지는 메서드에 표현
    // 특정 자원에 대해 요청하고 싶다면 @PathVariable로 경로에 id 추가

}
