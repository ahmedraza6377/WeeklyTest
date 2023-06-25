package com.geek.restaurantmanagement.restaurantController;

import com.geek.restaurantmanagement.restaurantModel.Restaurant;
import com.geek.restaurantmanagement.restaurantService.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
class RestaurantController {
    @Autowired
    RestService restservice;

    // Read
    @GetMapping("Rests")
    List<Restaurant> getAllRestaurant(){
        return restservice.getRestaurants();
    }
    @GetMapping("Rest/{restId}")
    Restaurant getRestaurantById(@PathVariable Integer restId ){
        return restservice.getRestaurantById(restId);
    }
    //Create
    @PostMapping("Rest")
    String addRestaurant(@RequestBody Restaurant restaurant){
        return restservice.addRestaurant(restaurant);
    }
    @PostMapping("RestList")
    String addRestaurants(@RequestBody List<Restaurant> rests){
        return restservice.addRestaurants(rests);
    }

    //delete
    @DeleteMapping("Rest/{restId}")
    String removeRestaurantById(@PathVariable Integer restId){
        return restservice.removeRestaurantById(restId);
    }

    //update
    @PutMapping("speciality/{restId}")
    String updateRestaurantSpecialityById(@PathVariable Integer restId,@RequestBody String speciality){
        return restservice.updateRestaurantSpecialityById(restId,speciality);
    }
}
