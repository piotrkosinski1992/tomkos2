package com.tomkos2.monolith.app.cart.domain;

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
  private Set<CartItem> cartItems = new HashSet<>();

  private Cart() {
  }

  public Cart(String username) {
    this.username = username;
  }

  public Cart(Long id) {
    this.id = id;
  }

  public void addToCart(CartItem cartItem) {
    if (bookAlreadyInCart(cartItem)) {
      cartItems.forEach(cartBook -> {
        if (cartBook.getIsbn().equals(cartItem.getIsbn())) {
          cartBook.increaseAmount(cartItem.getAmount());
        }
      });
    } else {
      cartItems.add(cartItem);
    }
  }

  private boolean bookAlreadyInCart(CartItem cartItem) {
    return cartItems.stream().map(CartItem::getIsbn).collect(Collectors.toList())
        .contains(cartItem.getIsbn());
  }

  public Set<CartItem> getCartItems() {
    return cartItems;
  }

  public String getUsername() {
    return username;
  }

  void setUsername(String username) {
    this.username = username;
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

  public void deleteFromCartById(String id) {
    this.cartItems = cartItems.stream().filter(book -> !book.getIsbn().equals(id))
        .collect(Collectors.toSet());
  }

  public CartItem getCartItemBy(String isbn) {
    return cartItems.stream()
        .filter(item -> item.getIsbn().equals(isbn))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Book with isbn: " + isbn + " not found in cart"));
  }
}
