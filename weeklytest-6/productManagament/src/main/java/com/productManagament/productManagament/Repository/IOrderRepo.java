package com.productManagament.productManagament.Repository;

import com.productManagament.productManagament.Model.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepo extends CrudRepository<Orders,Integer> {
}
