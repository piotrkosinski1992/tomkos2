package com.tomkos2.inventory.app.repo;

import com.tomkos2.inventory.app.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
