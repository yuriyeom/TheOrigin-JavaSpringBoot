package dev.glassym.controllerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

// @Controller vs @RestController
// 1. 뷰를 제공 or 데이터를 제공. 좀 더 넓은 범위. @ReponseBody를 붙여야 데이터를 보내고 싶을때 보내짐
// 2. 데이터를 주고받는데 주력. @ReponseBody를 붙이지 않아도 붙인 효과 Controller + ReponseBody
@RestController
@RequestMapping("/rest") // 경로 설정
public class SampleRestController {
    private static final Logger logger = LoggerFactory.getLogger(SampleRestController.class);

    @GetMapping("/sample-payload")
    public SamplePayload samplePayloadGet(){
        return new SamplePayload("glassym", 25, "Developer");
    }

    @GetMapping(
            value = "/sample-image",
            produces = MediaType.IMAGE_PNG_VALUE
    ) // 이미지,영상은 결과적으로 byte를 돌려준다. 스트림은 다름
    public byte[] sampleImage() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/static/img.png");
        return inputStream.readAllBytes();
    }
    // HTML 외에 데이터 전송을 위해 Body와 MediaType을 설정할 수 있다.


    @PostMapping("/sample-payload")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 정상적으로 처리됐을때 status가 어떻게 정의가 되야할지를 정의. 이건 바디가 없다는걸 status코드로 바로 전달하는거.
    public void samplePayloadPost(@RequestBody SamplePayload samplePayload){
        logger.info(samplePayload.toString());
    }

    @PostMapping(
            value = "/sample-multipart",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void sampleMultipartPost(
            @RequestParam("name") String name,
            @RequestParam("age") Integer age,
            @RequestParam("occupation") String occupation,
            @RequestParam("file") MultipartFile multipartFile){
        logger.info("name: " + name);
        logger.info("age: " + age);
        logger.info("occupation: "+ occupation);
        logger.info("file original name: " + multipartFile.getOriginalFilename());
    }
}
