package com.RestaurentManagement.demoRestaurentManagemen.Service;

import com.RestaurentManagement.demoRestaurentManagemen.Model.Admin;
import com.RestaurentManagement.demoRestaurentManagemen.Model.AuthenticationToken;
import com.RestaurentManagement.demoRestaurentManagemen.Model.User;
import com.RestaurentManagement.demoRestaurentManagemen.Repository.IAdminRepo;
import com.RestaurentManagement.demoRestaurentManagemen.Repository.IAuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminAuthService {
    @Autowired
    IAuthRepo authenticationRepo;

    public boolean authenticate(String email, String authTokenValue)
    {
        AuthenticationToken authToken = authenticationRepo.findFirstByTokenValue(authTokenValue);

        if(authToken == null)
        {
            return false;
        }

        String tokenConnectedEmail = authToken.getAdmin().getAdminEmail();

        return tokenConnectedEmail.equals(email);
    }

    public void saveAuthToken(AuthenticationToken authToken)
    {
        authenticationRepo.save(authToken);
    }

    public AuthenticationToken findFirstByUser(Admin admin) {
        return authenticationRepo.findFirstByAdmin(admin);
    }

    public void removeToken(AuthenticationToken token) {
        authenticationRepo.delete(token);
    }

    public AuthenticationToken findFirstByAdmin(Admin admin) {
        return authenticationRepo.findFirstByAdmin(admin);
    }
}
