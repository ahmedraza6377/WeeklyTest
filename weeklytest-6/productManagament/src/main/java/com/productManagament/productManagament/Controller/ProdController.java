package com.productManagament.productManagament.Controller;

import com.productManagament.productManagament.Model.Product;
import com.productManagament.productManagament.Service.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdController {
    @Autowired
    ProdService prodService;

    @PostMapping("prod")
    public Product createProduct(@RequestBody Product product) {
        return prodService.createProduct(product);
    }
    @GetMapping("prod")
    public Iterable<Product> getAllProducts() {
        return prodService.getAllProducts();
    }

    @GetMapping(params = "PCategory")
    public List<Product> getProductsByCategory(@RequestParam String PCategory) {
        return prodService.getProductsByCategory(PCategory);
    }

    @DeleteMapping("prod/{productId}")
    public void deleteProductById(@PathVariable Integer productId) {
        prodService.deleteProductById(productId);
    }
}
