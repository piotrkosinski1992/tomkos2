package com.tomkos2.monolith.app.inventory.usecase;

import com.tomkos2.monolith.app.cart.domain.CartItem;
import org.springframework.stereotype.Service;

@Service
public class InventoryUsecase {

  public boolean isBookInStock(String id) {
    CartItem cartItem = findByIsbn(id);
    return cartItem.getAmount() > 0;
  }

  public void decreaseBookAmount(CartItem cartItem) {
    CartItem inventoryBook = findByIsbn(cartItem.getIsbn());
    if (!inventoryBook.decreaseAmount(cartItem.getAmount())) {
      throw new RuntimeException(
          "There is less book than requested inside inventory: " + inventoryBook.getAmount());
    }
  }

  private CartItem findByIsbn(String isbn) {
    return new CartItem(isbn, Long.valueOf(isbn.substring(isbn.length() - 1)));
  }

  public void returnBook(CartItem cartItem) {
    CartItem dbBook = findByIsbn(cartItem.getIsbn());
    dbBook.increaseAmount(dbBook.getAmount());
  }
}
