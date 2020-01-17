package com.tomkos2.cart.app.usecase;

import com.tomkos2.cart.app.domain.Book;
import com.tomkos2.cart.app.domain.Cart;
import com.tomkos2.cart.app.domain.Response;
import com.tomkos2.cart.app.repo.CartRepository;
import com.tomkos2.cart.app.web.BookDTO;
import com.tomkos2.cart.app.web.CartItemsDTO;
import com.tomkos2.cart.app.web.config.UserInfo;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CartUsecase {

  private final RestTemplate restTemplate;
  private final CartRepository repository;

  public CartUsecase(RestTemplate restTemplate, CartRepository repository) {
    this.restTemplate = restTemplate;
    this.repository = repository;
  }

  @Transactional
  public void addToCart(Book book, UserInfo userInfo) {
    Response response = decreaseAmountInInventory(book);
    if (!response.isSuccess()) {
      throw new RuntimeException(response.getMessage());
    }
    Cart cart = findByUsername(userInfo);
    cart.addToCart(book);
  }

  private Response decreaseAmountInInventory(Book book) {
    return restTemplate
        .postForObject("http://inventory/decrease", book, Response.class);
  }

  public void createCart(String username) {
    repository.save(new Cart(username));
  }

  public List<BookDTO> getCartBooks(UserInfo userInfo) {
    Cart cart = findByUsername(userInfo);
    List<String> isbnList = cart.getBooks().stream().map(Book::getIsbn)
        .collect(Collectors.toList());
    List<BookDTO> booksInfo = restTemplate
        .postForObject("http://book/isbn/all", isbnList, CartItemsDTO.class).getBooks();

    return booksInfo.stream()
        .map(book -> addBookAmount(book, cart.getBooks()))
        .collect(Collectors.toList());
  }

  private BookDTO addBookAmount(BookDTO dto, Set<Book> books) {
    books.stream()
        .filter(p -> p.getIsbn().equals(dto.getIsbn()))
        .forEach(p -> dto.setAmount(p.getAmount()));
    return dto;
  }


  private Cart findByUsername(UserInfo userInfo) {
    return repository.findByUsername(userInfo.getUsername())
        .orElseThrow(() -> new RuntimeException(
            "No cart available for given username: " + userInfo.getUsername()));
  }

  //TODO tu może się stać że usunie z koszyka a nie usunie z inventory
  @Transactional
  public void deleteBookById(String id, UserInfo userInfo) {
    //TODO zwracanie do inventoy
      Cart cart = findByUsername(userInfo);
    restTemplate.postForObject("http://inventory/return/", id, String.class);
      cart.deleteFromCartById(id);
  }
}
