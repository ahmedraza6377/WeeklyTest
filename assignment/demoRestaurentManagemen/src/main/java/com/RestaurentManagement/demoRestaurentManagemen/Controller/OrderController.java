package com.RestaurentManagement.demoRestaurentManagemen.Controller;

import com.RestaurentManagement.demoRestaurentManagemen.Service.AuthService;
import com.RestaurentManagement.demoRestaurentManagemen.Service.OrderService;
import com.RestaurentManagement.demoRestaurentManagemen.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    AuthService authService;
    @Autowired
    UserService userService;


}
