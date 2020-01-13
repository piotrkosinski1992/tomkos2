package com.tomcos2.product.app.web;

import com.tomcos2.product.app.domain.Category;
import com.tomcos2.product.app.domain.Product;
import com.tomcos2.product.app.usecase.ProductUsecase;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

  private final ProductUsecase usecase;

  public ProductController(ProductUsecase usecase) {
    this.usecase = usecase;
  }

  @GetMapping("/category/{category}")
  public List<Product> findByCategory(@PathVariable String category) {
    return usecase.findByCategory(Category.valueOf(category));
  }

  @GetMapping("/id/{id}")
  public Product findById(@PathVariable Long id) {
    return usecase.findById(id);
  }

  @PostMapping("/like/{phrase}")
  public List<Product> findLike(@PathVariable String phrase) {
    return usecase.findLike(phrase);
  }
}
