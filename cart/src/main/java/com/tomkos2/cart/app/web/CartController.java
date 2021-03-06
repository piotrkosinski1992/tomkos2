package com.tomkos2.cart.app.web;

import com.tomkos2.cart.app.domain.Book;
import com.tomkos2.cart.app.usecase.CartUsecase;
import com.tomkos2.cart.app.web.config.UserInfo;
import com.tomkos2.cart.app.web.config.WithUser;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public void addToCart(@RequestBody Book book, @WithUser UserInfo userInfo) {
        usecase.addToCart(book, userInfo);
    }

    @PostMapping("/initialize/{userId}")
    public void initializeCart(@PathVariable String userId) {
        usecase.createCart(userId);
    }

    @GetMapping("/all")
    public List<BookDTO> getCartBooks(@WithUser UserInfo userInfo) {
        return usecase.getCartBooks(userInfo);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id, @WithUser UserInfo userInfo) {
      usecase.deleteBookById(id, userInfo);
    }
}
