package com.RestaurentManagement.demoRestaurentManagemen.Service;

import com.RestaurentManagement.demoRestaurentManagemen.Model.AuthenticationToken;
import com.RestaurentManagement.demoRestaurentManagemen.Model.User;
import com.RestaurentManagement.demoRestaurentManagemen.Repository.IAuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    IAuthRepo authenticationRepo;

    public boolean authenticate(String email, String authTokenValue)
    {
        AuthenticationToken authToken = authenticationRepo.findFirstByTokenValue(authTokenValue);

        if(authToken == null)
        {
            return false;
        }

        String tokenConnectedEmail = authToken.getUser().getUserEmail();

        return tokenConnectedEmail.equals(email);
    }

    public void saveAuthToken(AuthenticationToken authToken)
    {
        authenticationRepo.save(authToken);
    }

    public AuthenticationToken findFirstByUser(User user) {
        return authenticationRepo.findFirstByUser(user);
    }

    public void removeToken(AuthenticationToken token) {
        authenticationRepo.delete(token);
    }
}
