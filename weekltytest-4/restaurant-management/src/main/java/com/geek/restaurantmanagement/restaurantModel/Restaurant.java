package com.geek.restaurantmanagement.restaurantModel;

import lombok.*;

import java.util.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Restaurant {
    private Integer restId;

    private String restName;

    private String restAddress;

    private String restContact;

    private String speciality;

    private Integer restTotalStaff;

    private Map<Integer,String> restMenu;//here,I use hashmap for menu of food in key - value particular food corresponding particular key

    private Integer restRating;

}
