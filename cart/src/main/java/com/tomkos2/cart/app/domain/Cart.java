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
  private Set<Book> books = new HashSet<>();

  private Cart() {
  }

  public Cart(String username) {
    this.username = username;
  }

  public Cart(Long id) {
    this.id = id;
  }

  public void addToCart(Book book) {
    if (bookAlreadyInCart(book)) {
      books.forEach(cartBook -> {
        if (cartBook.getIsbn().equals(book.getIsbn())) {
            cartBook.increaseAmount(book.getAmount());
        }
      });
    } else {
      books.add(book);
    }
  }

  private boolean bookAlreadyInCart(Book book) {
    return books.stream().map(Book::getIsbn).collect(Collectors.toList())
        .contains(book.getIsbn());
  }

  public Set<Book> getBooks() {
    return books;
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
    this.books = books.stream().filter((Book book) -> !book.getIsbn().equals(id))
      .collect(Collectors.toSet());
  }
}
