package dev.glassym.mission2_challenge.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceSimple implements PostService {

    private static final Logger logger = LoggerFactory.getLogger(PostServiceSimple.class);
    private final PostRepository postRepository; // 인터페이스로 가져온다.

    public PostServiceSimple(
            @Autowired PostRepository postRepository // ioc컨테이너가 이렇게 인터페이스를 요구해도 만족되는 우선적인 구현체를 가져온다. 지금은 inmemory 클래스
    ){
        this.postRepository = postRepository;
    }

    @Override
    public void createPost(
            PostDto dto,
            List<MultipartFile> files
    ) throws IOException {

        List<FileDto> fileList = new ArrayList<>();

        if(!files.isEmpty()){
            int i=0;
            for(MultipartFile file : files){
                String originalFileName = file.getOriginalFilename();
                logger.info(originalFileName);
                String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files/";

                FileDto fileDto = new FileDto(i++, dto.getTitle(), originalFileName);

                fileList.add(fileDto);

                file.transferTo(new File(projectPath + originalFileName));
            }
            dto.setFiles(fileList);
            logger.info("최종 dto");
            logger.info(dto.toString());
        }
        this.postRepository.save(dto);
    }
//
//    @Override
//    public void createImgPost(PostDto dto, MultipartFile file) throws IOException {
//        // 저장 경로 지정
//        String projectPath = System.getProperty("user.dir") + "resources/static/files";
//        // 랜덤 파일 이름 생성
//        UUID uuid = UUID.randomUUID();
//        String fileName = uuid + "_" + file.getOriginalFilename();
//
//        File saveFile = new File(projectPath, fileName);
//
//        file.transferTo(saveFile);
//
//        this.postRepository.save(dto);
//    }

    @Override
    public List<PostDto> readPostAll() {
        return this.postRepository.findAll();
    }

    @Override
    public PostDto readPost(int id) {
        return this.postRepository.findById(id);
    }

    @Override
    public void updatePost(int id, PostDto dto) {
        this.postRepository.update(id, dto);
    }

    @Override
    public void deletePost(int id) {
        this.postRepository.delete(id);
    }
}
