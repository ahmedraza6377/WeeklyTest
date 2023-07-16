package com.RestaurentManagement.demoRestaurentManagemen.Controller;

import com.RestaurentManagement.demoRestaurentManagemen.Model.Admin;
import com.RestaurentManagement.demoRestaurentManagemen.Model.FoodItem;
import com.RestaurentManagement.demoRestaurentManagemen.Model.User;
import com.RestaurentManagement.demoRestaurentManagemen.Model.dto.SignInInput;
import com.RestaurentManagement.demoRestaurentManagemen.Model.dto.SignInInputAdmin;
import com.RestaurentManagement.demoRestaurentManagemen.Model.dto.SignUpOutput;
import com.RestaurentManagement.demoRestaurentManagemen.Service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;



    @Autowired
    FoodService foodService;

    @Autowired
    AuthService authService;

    @Autowired
    AdminAuthService adminAuthService;



    @PostMapping("admin/signup")
    public SignUpOutput signUpUser(@RequestBody Admin admin)
    {

        return adminService.signUpUser(admin);
    }

    @PostMapping("admin/signIn")
    public String sigInUser(@RequestBody @Valid SignInInputAdmin adminSignIn)
    {
        return adminService.signInUser(adminSignIn);
    }

    @DeleteMapping("admin/signOut")
    public String sigOutUser(@RequestParam String email, @RequestParam String token)
    {
        if(authService.authenticate(email,token)) {
            return adminService.sigOutUser(email);
        }
        else {
            return "Sign out not allowed for non authenticated user.";
        }

    }


    @GetMapping("Users")
    public List<User> getUsers(@RequestParam String adminEmail, @RequestParam String adminToken){
        if(adminAuthService.authenticate(adminEmail,adminToken)) {
            return adminService.getUsers();
        }
        else {
            return null;
        }

    }
    @PostMapping("admin/food")
    public String addFoods(@RequestBody List<FoodItem> food, @RequestParam String adminEmail, @RequestParam String adminToken){
        if(adminAuthService.authenticate(adminEmail,adminToken)) {
            return adminService.addFoods(food);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }

    }

    @DeleteMapping("food")
    public String removeFoods(@RequestBody List<Long> ids, @RequestParam String adminEmail, @RequestParam String adminToken){
        if(adminAuthService.authenticate(adminEmail,adminToken)) {
            return adminService.deleteFoods(ids);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }

    }


}
