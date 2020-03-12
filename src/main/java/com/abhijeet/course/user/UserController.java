package com.abhijeet.course.user;

import com.abhijeet.course.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable UUID id) {
        return userService.getUser(id);
    }

    @RequestMapping("/users/username/{username}")
    public Optional<User> getByUserName(@PathVariable String username) {
        return userService.getByUserName(username);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
