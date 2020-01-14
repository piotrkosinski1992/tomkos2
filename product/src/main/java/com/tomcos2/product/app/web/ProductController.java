package com.tomcos2.product.app.web;

import com.tomcos2.product.app.domain.Category;
import com.tomcos2.product.app.domain.Product;
import com.tomcos2.product.app.usecase.ProductUsecase;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

  private final ProductUsecase usecase;
  private final ProductMapper mapper;

  public ProductController(ProductUsecase usecase, ProductMapper mapper) {
    this.usecase = usecase;
    this.mapper = mapper;
  }

  @GetMapping("/category/{category}")
  public List<Product> findByCategory(@PathVariable String category) {
    return usecase.findByCategory(Category.valueOf(category));
  }

  @GetMapping("/id/{id}")
  public ProductDTO findById(@PathVariable Long id) {
    return mapper.toDTO(usecase.findById(id));
  }

  @PostMapping("/id/all")
  public ProductsDTO findAllById(@RequestBody List<Long> productIds) {
    return new ProductsDTO(usecase.findAllBy(productIds).stream()
        .map(mapper::toDTO)
        .collect(Collectors.toList()));
  }

  @GetMapping("/like/{phrase}")
  public List<ProductDTO> findLike(@PathVariable String phrase) {
    return usecase.findLike(phrase).stream()
        .map(mapper::toDTO)
        .collect(Collectors.toList());
  }
}
