package dev.glassym.auth.controller;

import dev.glassym.auth.entity.UserEntity;
import dev.glassym.auth.entity.UserRepository;
import dev.glassym.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("user")
public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserController(
            @Autowired UserRepository userRepository,
            @Autowired PasswordEncoder passwordEncoder
    ){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("login")
    public String login(){
        return "login-form";
    }

    @GetMapping("signup")
    public String signUp(){
        return "signup-form";
    }

    @PostMapping("signup")
    public String signupPost(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("password_check") String passwordCheck
    ){
        if(!password.equals(passwordCheck)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        UserEntity newUser = new UserEntity();
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(password));
        this.userRepository.save(newUser);

        return "redirect:/home";
    }
}
