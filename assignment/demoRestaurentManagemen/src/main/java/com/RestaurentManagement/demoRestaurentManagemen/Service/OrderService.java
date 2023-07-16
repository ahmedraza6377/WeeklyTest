package com.RestaurentManagement.demoRestaurentManagemen.Service;


import com.RestaurentManagement.demoRestaurentManagemen.Model.order;
import com.RestaurentManagement.demoRestaurentManagemen.Repository.IOrderRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {
    @Autowired
    IOrderRepo orderRepo;


    public order addOrder(order or) {
        return orderRepo.save(or);
    }
}
