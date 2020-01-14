package com.tomkos2.cart.app.web;

import com.tomkos2.cart.app.domain.Product;
import com.tomkos2.cart.app.usecase.CartUsecase;
import com.tomkos2.cart.app.web.config.UserInfo;
import com.tomkos2.cart.app.web.config.WithUser;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

  private final CartUsecase usecase;

  public CartController(CartUsecase usecase) {
    this.usecase = usecase;
  }

  @PostMapping("/add")
  public void addToCart(@RequestBody Product product, @WithUser UserInfo userInfo) {
    usecase.addToCart(product, userInfo);
  }

  @PostMapping("/initialize/{userId}")
  public void initializeCart(@PathVariable String userId) {
    usecase.createCart(userId);
  }

  @GetMapping("/all")
  public List<ProductDTO> getCartProducts(@WithUser UserInfo userInfo) {
    return usecase.getCartProducts(userInfo);
  }
}
