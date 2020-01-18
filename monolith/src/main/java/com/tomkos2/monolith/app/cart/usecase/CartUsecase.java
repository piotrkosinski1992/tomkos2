package com.tomkos2.monolith.app.cart.usecase;

import com.tomkos2.monolith.app.book.domain.Book;
import com.tomkos2.monolith.app.book.domain.BookDetails;
import com.tomkos2.monolith.app.book.usecase.BookUsecase;
import com.tomkos2.monolith.app.book.web.BookDTO;
import com.tomkos2.monolith.app.cart.domain.Cart;
import com.tomkos2.monolith.app.cart.domain.CartItem;
import com.tomkos2.monolith.app.cart.repo.CartRepository;
import com.tomkos2.monolith.app.cart.web.CartItemDTO;
import com.tomkos2.monolith.app.inventory.usecase.InventoryUsecase;
import com.tomkos2.monolith.app.user.domain.UserInfo;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CartUsecase {

  private final InventoryUsecase inventoryUsecase;
  private final BookUsecase bookUsecase;
  private final CartRepository cartRepository;

  public CartUsecase(InventoryUsecase inventoryUsecase, BookUsecase bookUsecase,
      CartRepository cartRepository) {
    this.inventoryUsecase = inventoryUsecase;
    this.bookUsecase = bookUsecase;
    this.cartRepository = cartRepository;
  }

  @Transactional
  public void addToCart(CartItem cartItem, String username) {
    inventoryUsecase.decreaseBookAmount(cartItem);
    Cart cart = findByUsername(username);
    cart.addToCart(cartItem);
  }

  @Transactional
  public void createCart(String username) {
    cartRepository.save(new Cart(username));
  }

  @Transactional
  public void deleteBookById(String id, String username) {
    Cart cart = findByUsername(username);
    inventoryUsecase.returnBook(cart.getCartItemBy(id));
    cart.deleteFromCartById(id);
  }

  public List<CartItemDTO> getCartItems(String username) {
    Cart cart = findByUsername(username);
    List<String> isbnList = cart.getCartItems().stream().map(CartItem::getIsbn)
        .collect(Collectors.toList());
    List<BookDetails> booksInfo = bookUsecase.findAllBy(isbnList);

    return booksInfo.stream()
        .map(book -> createCartItemDTO(book, cart.getCartItems()))
        .collect(Collectors.toList());
  }

  private CartItemDTO createCartItemDTO(BookDetails bookDetails, Set<CartItem> cartItems) {
    return cartItems.stream()
        .filter(p -> p.getIsbn().equals(bookDetails.getIsbn()))
        .map(p -> new CartItemDTO(bookDetails, p.getAmount()))
        .findFirst()
        .get();
  }

  private Cart findByUsername(String username) {
    Optional<Cart> cart = cartRepository.findByUsername(username);
    return cart.orElseGet(() -> cartRepository.save(new Cart(username)));
  }
}
