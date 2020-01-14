package com.tomcos2.product.app.web;

import com.tomcos2.product.app.domain.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public ProductDTO toDTO(Product product) {
        return new ProductDTO(
          product.getId(),
          product.getCategory().name(),
          product.getName(),
          product.getDescription(),
          product.getPrice().getStringValue()
        );
    }
}
