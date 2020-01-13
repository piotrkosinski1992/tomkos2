package com.tomkos2.user.usecase;

import com.tomkos2.user.domain.UserInfo;
import com.tomkos2.user.gateway.UserInfoRepository;
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
