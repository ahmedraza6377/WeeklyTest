package com.RestaurentManagement.demoRestaurentManagemen.Controller;

import com.RestaurentManagement.demoRestaurentManagemen.Model.User;
import com.RestaurentManagement.demoRestaurentManagemen.Model.dto.SignInInput;
import com.RestaurentManagement.demoRestaurentManagemen.Model.dto.SignUpOutput;
import com.RestaurentManagement.demoRestaurentManagemen.Model.order;
import com.RestaurentManagement.demoRestaurentManagemen.Service.AuthService;
import com.RestaurentManagement.demoRestaurentManagemen.Service.OrderService;
import com.RestaurentManagement.demoRestaurentManagemen.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    AuthService authService;

    @Autowired
    OrderService orderService;

    @PostMapping("user/signup")
    public SignUpOutput signUpUser(@RequestBody User user)
    {

        return userService.signUpUser(user);
    }

    @PostMapping("user/signIn")
    public String sigInUser(@RequestBody @Valid SignInInput signInInput)
    {
        return userService.signInUser(signInInput);
    }

    @DeleteMapping("user/signOut")
    public String sigOutUser(@RequestParam String email, @RequestParam String token)
    {
        if(authService.authenticate(email,token)) {
            return userService.sigOutUser(email);
        }
        else {
            return "Sign out not allowed for non authenticated user.";
        }

    }

    @PostMapping("order")
    public order create(@RequestBody order or, @RequestParam String email, @RequestParam String token)
    {
        if(authService.authenticate(email,token)) {
            return orderService.addOrder(or);
        }
        else {
            return null;
        }

    }

}
