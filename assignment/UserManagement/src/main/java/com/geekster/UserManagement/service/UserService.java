package com.geekster.UserManagement.service;

import com.geekster.UserManagement.model.User;
import com.geekster.UserManagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<User> getAllUsers() {
        return userRepo.getUsers();
    }

    public String createUsers(List<User> users) {
        List<User> originalList = getAllUsers();
        originalList.addAll(users);
        return "New users added";

    }

    public String createUser(User user) {
        List<User> originalList = getAllUsers();
        originalList.add(user);
        return "New user added";
    }

    public User userbyId(Integer uId){
    for(User user:userRepo.getUsers()){
        if(user.getUserId().equals(uId)){
            return user;
        }
    }
    throw new IllegalStateException("id not found");
    }

    public String updatecontactinfo(String uNO,Integer uId) {
        for(User user:userRepo.getUsers()){
            if(user.getUserId().equals(uId)){
                user.setUserContact(uNO);
                return "User info updated";
            }
        }
        return "userId Not Found";

    }

    public String updateAddressInfo(String add, Integer uId) {
        for(User user:userRepo.getUsers()){
            if(user.getUserId().equals(uId)){
                user.setAddress(add);
                return "User info updated";
            }
        }
        return "userId Not Found";
    }

    public String removeUser(Integer uId) {
        for(User user:userRepo.getUsers()){
            if(user.getUserId().equals(uId)){
                userRepo.delete(user);
                return "User deleted";
            }
        }
        return "userId Not Found";
    }
}
