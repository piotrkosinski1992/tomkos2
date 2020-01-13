package com.tomcos2.product;

import com.tomcos2.product.app.domain.Category;
import com.tomcos2.product.app.domain.Money;
import com.tomcos2.product.app.domain.Product;
import com.tomcos2.product.app.repo.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class ProductApplication implements CommandLineRunner {

  private final ProductRepository repository;

  public ProductApplication(ProductRepository repository) {
    this.repository = repository;
  }

  public static void main(String[] args) {
    SpringApplication.run(ProductApplication.class, args);
  }

  @Override
  public void run(String... args) {
    repository.save(new Product(1L, Category.ELECTRIC_GUITAR,"Epiphone Sg300", "shitty guitar for beginners", new Money(1600)));
    repository.save(new Product(2L, Category.ELECTRIC_GUITAR,"Epiphone Sg399", "shitty guitar for beginners", new Money(2600)));
    repository.save(new Product(3L, Category.ELECTRIC_GUITAR,"Epiphone Sg123", "shitty guitar for beginners", new Money(3600)));
    repository.save(new Product(4L, Category.ELECTRIC_GUITAR,"Epiphone DT31", "shitty guitar for beginners", new Money(4600)));
    repository.save(new Product(5L, Category.ELECTRIC_GUITAR,"Epiphone PB", "shitty guitar for beginners", new Money(5600)));
    repository.save(new Product(6L, Category.ELECTRIC_GUITAR,"Gibson Ltd", "good guitar for beginners", new Money(1600)));
    repository.save(new Product(7L, Category.ELECTRIC_GUITAR,"Ibanez Sg300", "very good guitar for profeszional", new Money(5600)));
    repository.save(new Product(8L, Category.ELECTRIC_GUITAR,"amg Sgq0", "so lala guitar for abcdedf", new Money(1500)));
    repository.save(new Product(9L, Category.ELECTRIC_GUITAR,"defil Sg300", "haha lolxd guitar for foobar", new Money(999.99)));
    repository.save(new Product(10L, Category.ELECTRIC_GUITAR,"epiphone td900", "hello kitty guitar for advanced", new Money(10)));
    repository.save(new Product(11L, Category.ELECTRIC_GUITAR,"surh 100", "noname guitar for nonames", new Money(100023)));
  }

  @LoadBalanced
  @Bean
  public RestTemplate getRestTemplate() {
    return new RestTemplate();
  }
}
