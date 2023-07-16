package com.RestaurentManagement.demoRestaurentManagemen.Repository;

import com.RestaurentManagement.demoRestaurentManagemen.Model.User;
import com.RestaurentManagement.demoRestaurentManagemen.Model.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepo extends JpaRepository<order,Long> {
}
