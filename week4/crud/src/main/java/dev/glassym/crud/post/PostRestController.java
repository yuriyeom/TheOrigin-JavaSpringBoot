package dev.glassym.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("post") // http://localhost:8080/post post인걸 보니 게시글 자원에 대한 요청일 것이다.
public class PostRestController {
    private static final Logger logger = LoggerFactory.getLogger(PostRestController.class);
//    private final List<PostDto> postList; // 초기화 후에 새로 할당할 수 없다.
    private final PostRepository postRepository;

    public PostRestController(
            @Autowired PostRepository postRepository
    ){
//        this.postList = new ArrayList<>();
        this.postRepository = postRepository;
    }

    // create
    // http://localhost:8080/post
    // POST /post
    // /post 경로에 POST 요청이 들어오면
    // REQUEST_BODY 에 따라서 게시글을 만들어 낸다.
    @PostMapping() // 없었던 걸 새로 생성해서 넣는것
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody PostDto postDto){
        logger.info(postDto.toString());
        this.postRepository.save(postDto);
    }

    // read
    // http://localhost:8080/post 게시글에 대한 정보를 볼거야
    // GET /post
    @GetMapping()
    public List<PostDto> readPostAll(){
        logger.info("in read post all");
        return this.postRepository.findAll();
    }

    // read one
    // GET /post/0/
    @GetMapping("{id}") // 파일이 나열됐으면 더블클릭해서 한 파일을 연다.
    public PostDto readPost(@PathVariable int id){ // query 쓰지 않고 path를 쓴다.
        logger.info("in read post");
        return this.postRepository.findById(id);
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
        this.postRepository.update(id, postDto);
    }

    // DELETE /post/0
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(
            @PathVariable("id") int id
    ){
        this.postRepository.delete(id);
    }

    // POST /post
    // GET /post/0/
    // GET /post
    // PUT /post/0/
    // DELETE /post/0

    // 어떤 작업을 하고 싶은지는 메서드에 표현
    // 특정 자원에 대해 요청하고 싶다면 @PathVariable로 경로에 id 추가

}
