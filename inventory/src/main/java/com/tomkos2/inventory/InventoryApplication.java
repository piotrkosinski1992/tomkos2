package com.tomkos2.inventory;

import com.tomkos2.inventory.app.domain.Product;
import com.tomkos2.inventory.app.repo.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class InventoryApplication implements CommandLineRunner {

  private final ProductRepository repository;

  public InventoryApplication(ProductRepository repository) {
    this.repository = repository;
  }

  public static void main(String[] args) {
    SpringApplication.run(InventoryApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    repository.save(new Product(1L, 1L));
    repository.save(new Product(2L, 0L));
    repository.save(new Product(3L, 120L));
    repository.save(new Product(4L, 10L));
    repository.save(new Product(5L, 1000L));
    repository.save(new Product(6L, 0L));
    repository.save(new Product(7L, 1213000L));
    repository.save(new Product(8L, 1213000L));
    repository.save(new Product(9L, 1213000L));
    repository.save(new Product(10L, 1213000L));
    repository.save(new Product(11L, 1213000L));
  }
}
