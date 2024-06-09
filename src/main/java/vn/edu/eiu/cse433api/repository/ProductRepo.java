package vn.edu.eiu.cse433api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.eiu.cse433api.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
