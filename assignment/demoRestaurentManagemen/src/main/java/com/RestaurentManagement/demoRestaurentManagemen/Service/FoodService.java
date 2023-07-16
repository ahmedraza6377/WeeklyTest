package com.RestaurentManagement.demoRestaurentManagemen.Service;

import com.RestaurentManagement.demoRestaurentManagemen.Model.FoodItem;
import com.RestaurentManagement.demoRestaurentManagemen.Model.User;
import com.RestaurentManagement.demoRestaurentManagemen.Repository.IFoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    IFoodRepo foodRepo;

    public List<FoodItem> getAllFoods() {
        return foodRepo.findAll();
    }
}
