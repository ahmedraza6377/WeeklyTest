package com.productManagament.productManagament.Service;

import com.productManagament.productManagament.Model.Product;
import com.productManagament.productManagament.Repository.IProdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdService {
    @Autowired
    IProdRepo prodRepo;

    public Product createProduct(Product product) {
        return prodRepo.save(product);
    }
    public Iterable<Product> getAllProducts() {
        return prodRepo.findAll();
    }

    public List<Product> getProductsByCategory(String category) {
        return prodRepo.findProductsByPCategory(category);
    }

    public void deleteProductById(Integer productId) {
        prodRepo.deleteById(productId);
    }
}
