package vn.edu.eiu.cse433api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.eiu.cse433api.entity.Product;
import vn.edu.eiu.cse433api.repository.ProductRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {



    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts() {return productRepo.findAll();}

    public Optional<Product> getProductById(int id) {return productRepo.findById(id);}

    public Product addProduct(Product product) {return  productRepo.save(product);}

    public void deleteProduct(int id) {productRepo.deleteById(id);}

    public Product updateProduct(Product product) {return productRepo.save(product);}

}
