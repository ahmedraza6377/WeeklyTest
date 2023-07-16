package com.RestaurentManagement.demoRestaurentManagemen.Repository;

import com.RestaurentManagement.demoRestaurentManagemen.Model.Admin;
import com.RestaurentManagement.demoRestaurentManagemen.Model.AuthenticationToken;
import com.RestaurentManagement.demoRestaurentManagemen.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthRepo extends JpaRepository<AuthenticationToken,Long> {

    AuthenticationToken findFirstByTokenValue(String authTokenValue);

    AuthenticationToken findFirstByUser(User user);

    AuthenticationToken findFirstByAdmin(Admin adminUser);
}
