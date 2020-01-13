package com.tomkos2.cart.app.usecase;

import com.tomkos2.cart.app.domain.Cart;
import com.tomkos2.cart.app.domain.Product;
import com.tomkos2.cart.app.domain.Response;
import com.tomkos2.cart.app.repo.CartRepository;
import com.tomkos2.cart.app.web.config.UserInfo;
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
  public void addToCart(Product product, UserInfo userInfo) {
    Response response = decreaseAmountInInventory(product);
    if (!response.isSuccess()) {
      throw new RuntimeException(response.getMessage());
    }
    Cart cart = repository.findByUsername(userInfo.getUsername())
        .orElseThrow(() -> new RuntimeException(
            "No cart available for given username: " + userInfo.getUsername()));
    cart.addToCart(product);
  }

  private Response decreaseAmountInInventory(Product product) {
    return restTemplate
        .postForObject("http://inventory/decrease", product, Response.class);
  }

  public void createCart(String username) {
    repository.save(new Cart(username));
  }
}
