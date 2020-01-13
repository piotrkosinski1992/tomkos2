package com.tomkos2.inventory.app.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

  @Id
  private Long id;
  private Long amount;

  private Product() {
  }

  public Product(Long id, Long amount) {
    this.id = id;
    this.amount = amount;
  }

  public Long getId() {
    return id;
  }

  public Long getAmount() {
    return amount;
  }

  public boolean decreaseAmount(Long amount) {
    if (this.amount < amount) {
      return false;
    }
    this.amount -= amount;
    return true;
  }

}
