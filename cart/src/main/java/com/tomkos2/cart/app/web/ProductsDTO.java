package com.tomkos2.cart.app.web;

import java.util.List;

public class ProductsDTO {

  private List<ProductDTO> products;

  public ProductsDTO() {
  }

  public List<ProductDTO> getProducts() {
    return products;
  }

  public void setProducts(List<ProductDTO> products) {
    this.products = products;
  }
}
