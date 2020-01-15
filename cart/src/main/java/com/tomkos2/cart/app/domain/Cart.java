package com.tomkos2.cart.app.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cart {

  @Id
  @GeneratedValue
  private Long id;

  private String username;

  @ElementCollection
  private Set<Product> products = new HashSet<>();

  private Cart() {
  }

  public Cart(String username) {
    this.username = username;
  }

  public Cart(Long id) {
    this.id = id;
  }

  public void addToCart(Product product) {
    if (productAlreadyInCart(product)) {
      products.forEach(cartProduct -> {
        if (cartProduct.getId().equals(product.getId())) {
            cartProduct.increaseAmount(product.getAmount());
        }
      });
    } else {
      products.add(product);
    }
  }

  private boolean productAlreadyInCart(Product product) {
    return products.stream().map(Product::getId).collect(Collectors.toList())
        .contains(product.getId());
  }

  public Set<Product> getProducts() {
    return products;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cart cart = (Cart) o;
    return id.equals(cart.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  public void deleteFromCartById(Long id) {
    this.products = products.stream().filter((Product product) -> !product.getId().equals(id))
      .collect(Collectors.toSet());
  }
}
