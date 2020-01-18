package com.tomkos2.monolith;

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

  private final UserInfoRepository repository;
  private final PasswordEncoder encoder;

  public MonolithApplication(UserInfoRepository repository,
      PasswordEncoder encoder) {
    this.repository = repository;
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
  public void run(String... args) throws Exception {
    repository.save(new UserInfo("user", encoder.encode("user")));
  }
}
