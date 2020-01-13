package com.tomkos2.cart;

import com.tomkos2.cart.app.domain.Cart;
import com.tomkos2.cart.app.repo.CartRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class CartApplication implements CommandLineRunner {

  private final CartRepository cartRepository;

  public CartApplication(CartRepository cartRepository) {
    this.cartRepository = cartRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(CartApplication.class, args);
  }

  @LoadBalanced
  @Bean
  public RestTemplate getRestTemplate() {
    return new RestTemplate();
  }

  @Override
  public void run(String... args) {
    cartRepository.save(new Cart("user"));
  }
}
