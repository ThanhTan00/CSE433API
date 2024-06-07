package vn.edu.eiu.cse433api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.eiu.cse433api.entity.Product;
import vn.edu.eiu.cse433api.repository.ProductRepo;

import java.util.List;
@RestController
@CrossOrigin("http://localhost:3000")
public class ProductController {

    @Autowired
    ProductRepo repo;
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        List<Product> products = repo.findAll();
        return products;
    }
}
