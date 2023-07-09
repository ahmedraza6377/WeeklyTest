package com.productManagament.productManagament.Service;

import com.productManagament.productManagament.Model.User;
import com.productManagament.productManagament.Repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    IUserRepo userRepo;


    public User createUser(User user) {
        return userRepo.save(user);
    }
    public User getUserById(Integer userId) throws ChangeSetPersister.NotFoundException {
        return userRepo.findById(userId).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }
}
