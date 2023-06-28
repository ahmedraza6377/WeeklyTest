package com.geek.UserManagement.controller;

import com.geek.UserManagement.model.User;
import com.geek.UserManagement.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.PUT;


@RestController
@Validated
public class UserController {

    @Autowired
    UserService userService;


    //read
    @GetMapping("users")
    List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }
    @GetMapping("user/{uId}")
    User getUserById(@PathVariable Integer uId)
    {
        return userService.getUserById(uId);
    }

    //create

    @PostMapping("users")
    String addUsers(@RequestBody @Valid List<User> users)
    {
        return userService.createUsers(users);
    }

    @PostMapping("user")
    String addUser(@Valid @RequestBody User user)
    {
        return userService.createUser(user);
    }

    //delete :
    @DeleteMapping("user/{uId}")
    String removeUser(@PathVariable Integer uId)
    {
       return userService.removeUser(uId);
    }

    @RequestMapping(value = "user/{id}/email/{emailId}",method = PUT)
    String updateEmail(@PathVariable Integer id, @PathVariable @Email String emailId)
    {
        return userService.updateEmail(id,emailId);
    }


}
