package dev.glassym.auth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {

    public static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @GetMapping
    public String adminHome(){
        return "admin";
    }
}
