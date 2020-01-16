package com.tomkos2.cart.app.domain;

import java.util.Objects;
import javax.persistence.Embeddable;

@Embeddable
public class Book {

  private String isbn;
  private Long amount;

  private Book() {
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String id) {
    this.isbn = id;
  }

  public Long getAmount() {
    return amount;
  }

  public void setAmount(Long amount) {
    this.amount = amount;
  }

  public void increaseAmount(Long value) {
    this.amount += value;
  }

  public void decreaseAmount(Long value) {
    this.amount -= value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book) o;
    return isbn.equals(book.isbn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isbn);
  }
}
