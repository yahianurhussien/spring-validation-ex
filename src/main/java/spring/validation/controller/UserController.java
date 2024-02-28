package spring.validation.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.validation.dto.UserRequest;
import spring.validation.entity.User;
import spring.validation.exception.UserNotFoundException;
import spring.validation.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest) {

        return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);

    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getAllUsers() {

        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Integer userId) throws UserNotFoundException {

        return ResponseEntity.ok(userService.getUser(userId));
    }
}


