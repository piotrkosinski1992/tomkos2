package com.tomkos2.cart.app.repo;

import com.tomkos2.cart.app.domain.Cart;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

  Optional<Cart> findByUsername(String username);
}
