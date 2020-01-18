package com.tomkos2.monolith.app.user.usecase;

import com.tomkos2.monolith.app.user.domain.UserInfo;
import com.tomkos2.monolith.app.user.gateway.UserInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class LoadUserInfo {

  private final UserInfoRepository repository;

  public LoadUserInfo(UserInfoRepository repository) {
    this.repository = repository;
  }

  public UserInfo loadByUsername(String username) {
    return repository.findByCredentialsUsername(username).orElseThrow(() -> new RuntimeException(username + " not found"));
  }
}
