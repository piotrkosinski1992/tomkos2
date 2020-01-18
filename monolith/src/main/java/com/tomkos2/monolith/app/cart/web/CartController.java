package com.tomkos2.monolith.app.cart.web;

import com.tomkos2.monolith.app.cart.domain.CartItem;
import com.tomkos2.monolith.app.cart.usecase.CartUsecase;
import java.security.Principal;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

  private final CartUsecase usecase;

  public CartController(CartUsecase usecase) {
    this.usecase = usecase;
  }

  @PostMapping("/add")
  public void addToCart(@RequestBody CartItem cartItem, Principal principal) {
    usecase.addToCart(cartItem, principal.getName());
  }

  @GetMapping("/all")
  public List<CartItemDTO> getCartItems(Principal principal) {
    return usecase.getCartItems(principal.getName());
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable String id, Principal principal) {
    usecase.deleteBookById(id, principal.getName());
  }
}
