package com.tomcos2.product.app.repo;

import com.tomcos2.product.app.domain.Category;
import com.tomcos2.product.app.domain.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findByCategory(Category category);
  List<Product> findByNameContainingIgnoreCase(String phrase);
}
