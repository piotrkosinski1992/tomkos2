package com.tomkos2.cart.app.domain;

import java.util.Objects;
import javax.persistence.Embeddable;

@Embeddable
public class Product {

  private Long id;
  private Long amount;

  private Product() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
    Product product = (Product) o;
    return id.equals(product.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
