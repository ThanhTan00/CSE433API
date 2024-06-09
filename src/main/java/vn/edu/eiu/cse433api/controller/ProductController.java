package vn.edu.eiu.cse433api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.edu.eiu.cse433api.entity.Product;
import vn.edu.eiu.cse433api.service.ProductService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@CrossOrigin("http://localhost:3000")
public class ProductController {
    final String URL = "D://Wallpapers";
    @Autowired
    private ProductService productService;
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable  int id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product addProduct(@ModelAttribute Product product, @RequestParam("imageData[]") MultipartFile image) throws IOException {
        String imageName = product.getName().replaceAll(" ", "").toLowerCase()+".jpg";
        Path path = Paths.get("D:/CSE_433/cse433-final-project-fe/public/images", imageName);
        Files.write(path, image.getBytes());
        product.setImage("/images/"+imageName);

        return productService.addProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }
}
