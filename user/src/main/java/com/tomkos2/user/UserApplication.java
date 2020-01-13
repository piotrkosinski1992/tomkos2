package com.tomkos2.user;

import com.tomkos2.user.domain.Role;
import com.tomkos2.user.domain.UserInfo;
import com.tomkos2.user.gateway.UserInfoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class UserApplication implements CommandLineRunner {

  private final UserInfoRepository repository;
  private final PasswordEncoder encoder;

  public UserApplication(UserInfoRepository repository,
      PasswordEncoder encoder) {
    this.repository = repository;
    this.encoder = encoder;
  }

  public static void main(String[] args) {
    SpringApplication.run(UserApplication.class, args);
  }

  @Override
  public void run(String... args) {
    repository.save(new UserInfo("user", encoder.encode("user")));
    repository.save(new UserInfo("admin", encoder.encode("admin"), Role.ADMIN));
  }

  @LoadBalanced
  @Bean
  public RestTemplate getRestTemplate() {
    return new RestTemplate();
  }
}
