package dev.glassym.exception;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import javax.print.attribute.standard.Media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
public class PostControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @Test
    public void readPost() throws Exception {
        // given : 어떤 데이터가 준비되어있을때
        // PostEntity가 존재할때
        final int id = 10;
        PostDto testDto = new PostDto();
        testDto.setId(id);
        testDto.setTitle("Unit Title");
        testDto.setContent("Unit Content");
        testDto.setWriter("unit");

        given(postService.readPost(id)).willReturn(testDto);
        // id=10이 Service의 readPost에 들어가면 testDto가 반환될 것이다.

        // when : 어떤 행위가 일어나면 (함수 호출 등)
        // 경로에 GET 요청이 오면
        final ResultActions actions = mockMvc.perform(get("/post/{id}", id))
                .andDo(print());

        // then : 어떤 결과가 나올 것이다.
        // PostDto가 반환된다.
        actions.andExpectAll(
                status().isOk(),
                content().contentType(MediaType.APPLICATION_JSON),
                jsonPath("$.title", is("Unit Title")),
                jsonPath("$.content", is("Unit Content")),
                jsonPath("$.writer", is("unit"))
        );
    }

    @Test
    public void readPostAll() throws Exception {
        // given
        PostDto testDto1 = new PostDto();
        testDto1.setId(10);
        testDto1.setTitle("Unit Title");
        testDto1.setContent("Unit Content");
        testDto1.setWriter("unit");

        PostDto testDto2 = new PostDto();
        testDto2.setId(10);
        testDto2.setTitle("readAll Title");
        testDto2.setContent("readAll Content");
        testDto2.setWriter("all");

        List<PostDto> postDtoList = Arrays.asList(testDto1, testDto2);

        given(postService.readPostAll()).willReturn(postDtoList);

        // when
        final ResultActions actions = mockMvc.perform(get("/post"))
                .andDo(print());

        // then
        actions.andExpectAll(
                status().isOk(),
                content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON),
                jsonPath("$", hasSize(postDtoList.size()))
        );
    }
}