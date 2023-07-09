package com.productManagament.productManagament.Controller;

import com.productManagament.productManagament.Model.User;
import com.productManagament.productManagament.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("user")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("user/{userId}")
    public User getUserById(@PathVariable Integer userId) throws ChangeSetPersister.NotFoundException {
        return userService.getUserById(userId);
    }
}
