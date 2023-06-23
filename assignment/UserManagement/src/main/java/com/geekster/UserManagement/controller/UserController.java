package com.geekster.UserManagement.controller;

import com.geekster.UserManagement.model.User;
import com.geekster.UserManagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public User getuserbyid(@PathVariable Integer uId){
        return userService.userbyId(uId);
    }


    //create

    @PostMapping("users")
    String addUsers(@RequestBody List<User> users)
    {
        return userService.createUsers(users);
    }

    @PostMapping("user")
    String addUser(@RequestBody User user)
    {
        return userService.createUser(user);
    }

    //update
    @PutMapping("user/contact/{uId}")
    String updatecontactinfo(@RequestBody String uNO,@PathVariable Integer uId){
        return userService.updatecontactinfo(uNO,uId);
    }
    @PutMapping("user/{uId}")
    String updateAddressInfo(@RequestBody String add,@PathVariable Integer uId){
        return userService.updateAddressInfo(add,uId);
    }
    //delete
    @DeleteMapping("user/{uId}")
    String removeUser(@PathVariable Integer uId){
        return userService.removeUser(uId);
    }

}
