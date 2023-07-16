package com.RestaurentManagement.demoRestaurentManagemen.Repository;

import com.RestaurentManagement.demoRestaurentManagemen.Model.FoodItem;
import com.RestaurentManagement.demoRestaurentManagemen.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFoodRepo extends JpaRepository<FoodItem,Long> {
}
