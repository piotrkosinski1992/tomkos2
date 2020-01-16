package com.tomkos2.cart.app.web;

import com.tomkos2.cart.app.domain.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

  public Product mapToEntity(ProductDTO productDTO) {
    return new Product(productDTO.getId(), productDTO.getAmount());
  }
}
