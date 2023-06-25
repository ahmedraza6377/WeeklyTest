package com.geek.restaurantmanagement.restaurantRepository;

import com.geek.restaurantmanagement.restaurantModel.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RestRepo {
    @Autowired
    List<Restaurant> restaurantList;

    public List<Restaurant> getAllRestaurant(){
        return restaurantList;
    }
}
