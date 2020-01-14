package com.tomcos2.product.app.web;

import java.util.List;

public class ProductsDTO {

  private List<ProductDTO> products;

  public ProductsDTO() {
  }

  public ProductsDTO(List<ProductDTO> products) {
    this.products = products;
  }

  public List<ProductDTO> getProducts() {
    return products;
  }

  public void setProducts(List<ProductDTO> products) {
    this.products = products;
  }
}
