package com.tomkos2.monolith.app.cart.repo;

import com.tomkos2.monolith.app.cart.domain.Cart;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

  Optional<Cart> findByUsername(String username);
}
