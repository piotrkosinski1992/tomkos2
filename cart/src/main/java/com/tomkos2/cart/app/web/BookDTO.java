package com.tomkos2.cart.app.web;

public class BookDTO {

  private String isbn;
  private String name;
  private Long amount;
  private String price;

  public BookDTO() {
  }

  public BookDTO(String isbn, String name, Long amount, String price) {
    this.isbn = isbn;
    this.name = name;
    this.amount = amount;
    this.price = price;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
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
