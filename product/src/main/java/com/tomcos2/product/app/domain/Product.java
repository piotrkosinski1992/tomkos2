package com.tomcos2.product.app.domain;

import java.util.Objects;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Product {

  @Id
  private Long id;

  @Enumerated(EnumType.STRING)
  private Category category;

  private String name;

  private String description;

  @Embedded
  private Money price;

  private Product() {
  }

  public Product(Long id, Category category, String name, String description, Money price) {
    this.id = id;
    this.category = category;
    this.name = name;
    this.description = description;
    this.price = price;
  }

  public Long getId() {
    return id;
  }

  public Category getCategory() {
    return category;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public Money getPrice() {
    return price;
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
