package dev.glassym.mission3_challenge.controller;

import dev.glassym.mission3_challenge.model.UserDto;
import dev.glassym.mission3_challenge.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Profile("user")
@RestController
@RequestMapping("user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(this.userService.createUser(userDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> readUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.userService.readUser(id));
    }

    @GetMapping
    public ResponseEntity<Collection<UserDto>> readUserAll(){
        return ResponseEntity.ok(this.userService.readUserAll());
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody UserDto userDto){
        this.userService.updateUser(id, userDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> DeleteUser(@PathVariable("id") Long id){
        this.userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
