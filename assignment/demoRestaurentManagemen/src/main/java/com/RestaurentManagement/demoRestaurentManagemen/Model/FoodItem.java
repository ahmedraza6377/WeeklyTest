package com.RestaurentManagement.demoRestaurentManagemen.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private double price;

    // Constructors, getters, and setters

    // Method to create a food item (only accessible by admin)
//    public static FoodItem createFoodItem(String title, String description, double price) {
//        FoodItem foodItem = new FoodItem();
//        foodItem.setTitle(title);
//        foodItem.setDescription(description);
//        foodItem.setPrice(price);
//        return foodItem;
//    }
}
