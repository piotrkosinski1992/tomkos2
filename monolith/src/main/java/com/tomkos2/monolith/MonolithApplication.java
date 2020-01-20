package com.tomkos2.monolith;

import com.tomkos2.monolith.app.book.domain.Category;
import com.tomkos2.monolith.app.book.repo.BookRepository;
import com.tomkos2.monolith.app.book.repo.CategoryRepository;
import com.tomkos2.monolith.app.user.domain.UserInfo;
import com.tomkos2.monolith.app.user.gateway.UserInfoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MonolithApplication implements CommandLineRunner {

  private final UserInfoRepository userRepository;
  private final CategoryRepository categoryRepository;
  private final PasswordEncoder encoder;

  public MonolithApplication(UserInfoRepository userRepository,
      CategoryRepository categoryRepository, PasswordEncoder encoder) {
    this.userRepository = userRepository;
    this.categoryRepository = categoryRepository;
    this.encoder = encoder;
  }

  public static void main(String[] args) {
    SpringApplication.run(MonolithApplication.class, args);
  }

  @Bean
  public RestTemplate getRestTemplate() {
    return new RestTemplate();
  }

  @Override
  public void run(String... args) {
    userRepository.save(new UserInfo("user", encoder.encode("user")));

    categoryRepository.save(new Category("JAVA"));
    categoryRepository.save(new Category("ANGULAR"));
    categoryRepository.save(new Category("SQL"));
    categoryRepository.save(new Category("PYTHON"));
    categoryRepository.save(new Category("SWIFT"));
    categoryRepository.save(new Category("LINUX"));
    categoryRepository.save(new Category("PERL"));
    categoryRepository.save(new Category("CSS"));
  }
}
