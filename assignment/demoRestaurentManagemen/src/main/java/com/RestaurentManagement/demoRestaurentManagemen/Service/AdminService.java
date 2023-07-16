package com.RestaurentManagement.demoRestaurentManagemen.Service;

import com.RestaurentManagement.demoRestaurentManagemen.Model.Admin;
import com.RestaurentManagement.demoRestaurentManagemen.Model.AuthenticationToken;
import com.RestaurentManagement.demoRestaurentManagemen.Model.FoodItem;
import com.RestaurentManagement.demoRestaurentManagemen.Model.User;
import com.RestaurentManagement.demoRestaurentManagemen.Model.dto.SignInInput;
import com.RestaurentManagement.demoRestaurentManagemen.Model.dto.SignInInputAdmin;
import com.RestaurentManagement.demoRestaurentManagemen.Model.dto.SignUpOutput;
import com.RestaurentManagement.demoRestaurentManagemen.Repository.IAdminRepo;
import com.RestaurentManagement.demoRestaurentManagemen.Repository.IFoodRepo;
import com.RestaurentManagement.demoRestaurentManagemen.Repository.IUserRepo;
import com.RestaurentManagement.demoRestaurentManagemen.Service.Utility.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    IAdminRepo adminRepo;
    @Autowired
    IFoodRepo foodRepo;

    @Autowired
    IUserRepo userRepo;

    @Autowired
    AuthService authService;

    @Autowired
    AdminAuthService adminAuthService;



    public SignUpOutput signUpUser(Admin admin) {

        boolean signUpStatus = true;
        String signUpStatusMessage = null;

        String newEmail = admin.getAdminEmail();

        if(newEmail == null)
        {
            signUpStatusMessage = "Invalid email";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }

        //check if this user email already exists ??
        Admin existingUser = adminRepo.findFirstByAdminEmail(newEmail);

        if(existingUser != null)
        {
            signUpStatusMessage = "Email already registered!!!";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }

        //hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(admin.getPassword());

            //saveAppointment the user with the new encrypted password

            admin.setPassword(encryptedPassword);
            adminRepo.save(admin);

            return new SignUpOutput(signUpStatus, "admin registered successfully!!!");
        }
        catch(Exception e)
        {
            signUpStatusMessage = "Internal error occurred during sign up";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }
    }


    public String signInUser(SignInInputAdmin signInInput) {


        String signInStatusMessage = null;

        String signInEmail = signInInput.getEmail();

        if(signInEmail == null)
        {
            signInStatusMessage = "Invalid email";
            return signInStatusMessage;


        }

        //check if this user email already exists ??
        Admin existingUser = adminRepo.findFirstByAdminEmail(signInEmail);

        if(existingUser == null)
        {
            signInStatusMessage = "Email not registered!!!";
            return signInStatusMessage;

        }

        //match passwords :

        //hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(signInInput.getPassword());
            if(existingUser.getPassword().equals(encryptedPassword))
            {
                //session should be created since password matched and user id is valid
                AuthenticationToken authToken  = new AuthenticationToken(existingUser);
                adminAuthService.saveAuthToken(authToken);
                return "login Successfully";
            }
            else {
                signInStatusMessage = "Invalid credentials!!!";
                return signInStatusMessage;
            }
        }
        catch(Exception e)
        {
            signInStatusMessage = "Internal error occurred during sign in";
            return signInStatusMessage;
        }

    }


    public String sigOutUser(String email) {

        Admin admin = adminRepo.findFirstByAdminEmail(email);
        AuthenticationToken token = adminAuthService.findFirstByAdmin(admin);
        adminAuthService.removeToken(token);
        return "User Signed out successfully";
    }



    public String addFoods(List<FoodItem> food) {
        foodRepo.saveAll(food);
        return "added";
    }

    public String deleteFoods(List<Long> ids) {
        foodRepo.deleteAllById(ids);
        return "deleted";
    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }
}
