package dev.glassym.community.controller;

import dev.glassym.community.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final AreaRepository areaRepository;
    private final UserService userService;
//    private final CommunityUserDetailsService userManager;

    public UserController(
//            @Autowired UserRepository userRepository,
//            @Autowired PasswordEncoder passwordEncoder,
//            @Autowired AreaRepository areaRepository,
            @Autowired UserService userService
//            @Autowired CommunityUserDetailsService userManager
            ) {
        this.userService = userService;
//        this.passwordEncoder = passwordEncoder;
//        this.userRepository = userRepository;
//        this.areaRepository = areaRepository;
//        this.userManager = userManager;
    }

    @GetMapping("login")
    public String login(){
        return "login-form";
    }

    @GetMapping("signup")
    public String signup(){
        return "signup-form";
    }

    @PostMapping("signup")
    public String signupPost(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("password_check") String passwordCheck,
            @RequestParam(value = "is_shop_owner", defaultValue = "false") Boolean isShopOwner
    ){
        if(!password.equals(passwordCheck)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
//        userManager.createUser(username, password, isShopOwner);
//        UserEntity userEntity = new UserEntity();
//        userEntity.setUsername(username);
//        userEntity.setPassword(passwordEncoder.encode(password));
//        Optional<AreaEntity> residence = this.areaRepository.findById((long) (Math.random() * 3 + 1));
//        userEntity.setResidence(residence.get());
//        userEntity.setShopOwner(isShopOwner);
//        logger.info("is shop owner : " + isShopOwner);
//        this.userRepository.save(userEntity);
        return "redirect:/home";
    }


//    @PostMapping
//    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
//        return ResponseEntity.ok(this.userService.createUser(userDto));
//    }
//
//    @GetMapping("{id}")
//    public ResponseEntity<UserDto> readUser(@PathVariable("id") Long id) {
//        return ResponseEntity.ok(this.userService.readUser(id));
//    }
//
//    @GetMapping
//    public ResponseEntity<Collection<UserDto>> readUserAll(){
//        return ResponseEntity.ok(this.userService.readUserAll());
//    }
//
//    @PutMapping("{id}")
//    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody UserDto userDto){
//        this.userService.updateUser(id, userDto);
//        return ResponseEntity.noContent().build();
//    }
//
//    @DeleteMapping("{id}")
//    public ResponseEntity<?> DeleteUser(@PathVariable("id") Long id){
//        this.userService.deleteUser(id);
//        return ResponseEntity.noContent().build();
//    }
}
