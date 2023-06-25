package com.geek.restaurantmanagement.restaurantService;

import com.geek.restaurantmanagement.restaurantModel.Restaurant;
import com.geek.restaurantmanagement.restaurantRepository.RestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestService {
    @Autowired
    RestRepo restrepo;
    //for get all restaurants
    public List<Restaurant> getRestaurants() {

        return restrepo.getAllRestaurant();
    }

    //get restaurant by id
    public Restaurant getRestaurantById(Integer restId) {
        for(Restaurant rest:getRestaurants()){
            if(rest.getRestId().equals(restId)){
                return rest;
            }
        }
        throw new IllegalStateException("id Not Found");
    }

    //add particular restaurant
    public String addRestaurant(Restaurant restaurant) {
        getRestaurants().add(restaurant);
        return "Restaurant added";
    }

    //add list of restaurants
    public String addRestaurants(List<Restaurant> rests) {
        getRestaurants().addAll(rests);
        return "List of Restauarnts Added";
    }

    //delete restaurant by id
    public String removeRestaurantById(Integer restId) {
        for(Restaurant rest:getRestaurants()){
            if(rest.getRestId().equals(restId)){
                getRestaurants().remove(rest);
                return "restaurant removed";
            }
        }
        return "Id Not Found";
    }

    //update particular restaurants info by id
    public String updateRestaurantSpecialityById(Integer restId, String speciality) {
        for(Restaurant rest:getRestaurants()){
            if(rest.getRestId().equals(restId)){
                rest.setSpeciality(speciality);
                return "speciality updated";
            }
        }
        return "Id Not found";
    }





}
