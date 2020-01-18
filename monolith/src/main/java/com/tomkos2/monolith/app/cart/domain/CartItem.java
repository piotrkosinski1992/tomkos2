package com.tomkos2.monolith.app.cart.domain;

import java.util.Objects;
import javax.persistence.Embeddable;

@Embeddable
public class CartItem {

  private String isbn;
  private Long amount;

  private CartItem() {
  }

  public CartItem(String isbn, Long amount) {
    this.isbn = isbn;
    this.amount = amount;
  }

  public String getIsbn() {
    return isbn;
  }

  void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Long getAmount() {
    return amount;
  }

  void setAmount(Long amount) {
    this.amount = amount;
  }

  public boolean decreaseAmount(Long amount) {
    return this.amount >= amount;
  }

  public void increaseAmount(Long amount) {
    this.amount += amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CartItem cartItem = (CartItem) o;
    return isbn.equals(cartItem.isbn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isbn);
  }
}
