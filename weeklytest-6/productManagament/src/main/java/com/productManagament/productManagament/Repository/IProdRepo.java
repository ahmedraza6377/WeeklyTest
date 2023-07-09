package com.productManagament.productManagament.Repository;

import com.productManagament.productManagament.Model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProdRepo extends CrudRepository<Product,Integer> {
    List<Product> findProductsByPCategory(String category);
}
