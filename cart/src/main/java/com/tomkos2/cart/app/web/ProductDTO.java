package com.tomkos2.cart.app.web;

public class ProductDTO {

  private Long id;
  private String name;
  private Long amount;
  private String price;

  public ProductDTO() {
  }

  public ProductDTO(Long id, String name, Long amount, String price) {
    this.id = id;
    this.name = name;
    this.amount = amount;
    this.price = price;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getAmount() {
    return amount;
  }

  public void setAmount(Long amount) {
    this.amount = amount;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }
}
