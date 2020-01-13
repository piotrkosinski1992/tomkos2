package com.tomkos2.user.usecase;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tomkos2.user.domain.UserInfo;
import com.tomkos2.user.gateway.UserInfoRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SaveUserInfo {

  private final PasswordEncoder encoder;
  private final UserInfoRepository repository;
  private final RestTemplate restTemplate;

  public SaveUserInfo(PasswordEncoder encoder, UserInfoRepository repository,
      RestTemplate restTemplate) {
    this.encoder = encoder;
    this.repository = repository;
    this.restTemplate = restTemplate;
  }

  @HystrixCommand(fallbackMethod = "saveUserFailedFallback")
  public void saveUserInfo(String username, String password) {
    if (repository.findByCredentialsUsername(username).isPresent()) {
      throw new RuntimeException("User with username: " + username + " already exist");
    }

    restTemplate.postForObject("http://cart/initialize/" + username, Void.class, Void.class);
    repository.save(new UserInfo(username, encoder.encode(password)));
  }

  public void saveUserFailedFallback(String username, String password) {
    System.out.println("zapis failed");
  }

}
