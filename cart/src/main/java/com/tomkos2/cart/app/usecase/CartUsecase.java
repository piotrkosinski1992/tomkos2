package com.tomkos2.cart.app.usecase;

import com.tomkos2.cart.app.domain.Cart;
import com.tomkos2.cart.app.domain.Product;
import com.tomkos2.cart.app.domain.Response;
import com.tomkos2.cart.app.repo.CartRepository;
import com.tomkos2.cart.app.web.ProductDTO;
import com.tomkos2.cart.app.web.ProductsDTO;
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
  public void addToCart(Product product, UserInfo userInfo) {
    Response response = decreaseAmountInInventory(product);
    if (!response.isSuccess()) {
      throw new RuntimeException(response.getMessage());
    }
    Cart cart = findByUsername(userInfo);
    cart.addToCart(product);
  }

  private Response decreaseAmountInInventory(Product product) {
    return restTemplate
        .postForObject("http://inventory/decrease", product, Response.class);
  }

  public void createCart(String username) {
    repository.save(new Cart(username));
  }

  public List<ProductDTO> getCartProducts(UserInfo userInfo) {
    Cart cart = findByUsername(userInfo);
    List<Long> ids = cart.getProducts().stream().map(Product::getId)
        .collect(Collectors.toList());
    List<ProductDTO> productsInfo = restTemplate
        .postForObject("http://product/id/all", ids, ProductsDTO.class).getProducts();

    return productsInfo.stream()
        .map(product -> addProductAmount(product, cart.getProducts()))
        .collect(Collectors.toList());
  }

  private ProductDTO addProductAmount(ProductDTO dto, Set<Product> products) {
    products.stream()
        .filter(p -> p.getId().equals(dto.getId()))
        .forEach(p -> dto.setAmount(p.getAmount()));
    return dto;
  }


  private Cart findByUsername(UserInfo userInfo) {
    return repository.findByUsername(userInfo.getUsername())
        .orElseThrow(() -> new RuntimeException(
            "No cart available for given username: " + userInfo.getUsername()));
  }
}
