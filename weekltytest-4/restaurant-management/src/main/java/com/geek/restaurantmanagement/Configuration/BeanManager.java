package com.geek.restaurantmanagement.Configuration;

import com.geek.restaurantmanagement.restaurantModel.Restaurant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class BeanManager {
       @Bean
   public List<Restaurant> getIntializedList(){
          Map<Integer,String> menu=new HashMap<>();
          menu.put(1,"Dal fry");
           menu.put(2,"chili paneer");
           menu.put(3,"jira rice");
           menu.put(4,"dam biryani");

           Restaurant rest=new Restaurant(0,"restaurants0","India","015125693", "IndianFood",50,menu,5);
           List<Restaurant> restList=new ArrayList<>();
           restList.add(rest);
           return restList;
       }
}
