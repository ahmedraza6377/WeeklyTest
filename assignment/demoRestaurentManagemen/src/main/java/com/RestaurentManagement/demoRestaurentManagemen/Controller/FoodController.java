package com.RestaurentManagement.demoRestaurentManagemen.Controller;

import com.RestaurentManagement.demoRestaurentManagemen.Model.FoodItem;
import com.RestaurentManagement.demoRestaurentManagemen.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {
    @Autowired
    FoodService foodService;

    @GetMapping("FoodItems")
    public List<FoodItem> getAllFoodItems(){
        return foodService.getAllFoods();
    }
}
