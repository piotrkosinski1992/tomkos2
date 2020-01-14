package com.tomcos2.product.app.usecase;

import com.tomcos2.product.app.domain.Category;
import com.tomcos2.product.app.domain.Product;
import com.tomcos2.product.app.repo.ProductRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductUsecase {

  private final RestTemplate restTemplate;
  private final ProductRepository repository;

  public ProductUsecase(RestTemplate restTemplate, ProductRepository repository) {
    this.restTemplate = restTemplate;
    this.repository = repository;
  }

  public List<Product> findByCategory(Category category) {
    return repository.findByCategory(category).stream()
        .filter(this::isAvailableInStock)
        .collect(Collectors.toList());
  }

  private Boolean isAvailableInStock(Product product) {
    return restTemplate
        .getForObject("http://inventory/id/" + product.getId() + "/instock", Boolean.class);
  }

  public Product findById(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Product with id " + id + " not found"));
  }

  public List<Product> findLike(String phrase) {
    return repository.findByNameContainingIgnoreCase(phrase).stream()
        .filter(this::isAvailableInStock)
        .collect(Collectors.toList());
  }

  public List<Product> findAllBy(List<Long> productIds) {
    return repository.findAllById(productIds);
  }
}
