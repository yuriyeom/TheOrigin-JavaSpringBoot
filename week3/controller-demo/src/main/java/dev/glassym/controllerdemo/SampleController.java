package dev.glassym.controllerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

// 이 클래스가 ioc 컨테이너의 관리를 받는 빈이 된다.
@Controller
@RequestMapping("view")
public class SampleController {
    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    @RequestMapping(
            value = "/hello",
            method = RequestMethod.GET
    )
    public String hello(){
        return "hello";
    }

    @GetMapping("/sample-jsp")
    public String sampleJsp(Model model){ // GetMapping 안의 model에 전달할 데이터를 저장
        logger.info("in sample jsp");
        List<SamplePayload> profiles = new ArrayList<>();
        profiles.add(new SamplePayload("Adam", 22, "Student"));
        profiles.add(new SamplePayload("john", 30, "Developer"));
        profiles.add(new SamplePayload("emily", 25, "Doctor"));

        model.addAttribute("profiles", profiles);

        return "view-jsp"; // view resolver로 들어감 자기가 제공할 수 있는 페이지가 존재하지 않으면 view-jsp라는 경로로 요청을 보냄냄
   } // prefix(/WEB-INF/jps) + view-jsp + suffix(.jsp) => view-jsp.jsp파일 유추

    @GetMapping("/sample-thyme")
    public ModelAndView sampleThyme(){
        logger.info("in sample thyme");
        ModelAndView modelAndView = new ModelAndView();
        List<SamplePayload> profiles = new ArrayList<>();
        profiles.add(new SamplePayload("Adam", 22, "Student"));
        profiles.add(new SamplePayload("john", 30, "Developer"));
        profiles.add(new SamplePayload("emily", 25, "Doctor"));
        modelAndView.addObject("profiles", profiles);
        modelAndView.setViewName("view-thyme");
        return modelAndView;
    }
    @GetMapping("/get-profile")
    public @ResponseBody SamplePayload getProfile(){
        return new SamplePayload("glassym", 10, "Developer");
    }
/*
    // 경로 설정.
    @GetMapping(
            value = "/hello" // URL의 path
    )
    public String hello(@RequestParam(name = "id", required = false, defaultValue = "") String id){
        logger.info("Path: Hello");
        logger.info("Query Param id: " + id);
        return "/hello.html";
    }
    // @RequestParam을 사용하면 url에서 쿼리의 내용을 가져올 수 있음
    // require가 false이니까 id 값이 없어도 괜찮음
    // ex) http://localhost:8080/hello?id=glassym

    // RequestMapping보다 이 어노테이션을 더 권장
    @GetMapping(
            value = "/hello/{id}"
    )
    public String helloPath(@PathVariable("id") String id){
        logger.info("Path Variable is: " + id);
        return "/hello.html";
    }

    @GetMapping("/get-profile")
    public @ResponseBody SamplePayload getProfile(){
        return new SamplePayload("glassym", 10, "Developer");
    }
    // 데이터는 http요청 응답의 바디에 작성되므로 @ResponseBody
    // 뷰 리졸버를 거치지 않고 바로 데이터를 클라이언트에게 돌려준다.

    // 일반적인 자바 객체를 제이슨 같은 형식으로 만들어서 전달해줄 수 있다.
    // @ResponseBody 어떤 오브젝트의 데이터를 바디에 포함시켜 전송하고 싶을때,
    // 없으면 리턴되는 String값이 뷰 리졸버로 들어가면서 어떤 html을 가져올지 결정하게 됨
    // 있을땐 뷰를 찾는게 아니라 리턴값 자체의 데이터를 바디로 사용하게됨
*/
}
