package com.tomkos2.monolith.app.user.usecase;

import com.tomkos2.monolith.app.cart.usecase.CartUsecase;
import com.tomkos2.monolith.app.user.domain.UserInfo;
import com.tomkos2.monolith.app.user.gateway.UserInfoRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SaveUserInfo {

  private final PasswordEncoder encoder;
  private final UserInfoRepository repository;
  private final CartUsecase cartUsecase;

  public SaveUserInfo(PasswordEncoder encoder, UserInfoRepository repository,
      CartUsecase cartUsecase) {
    this.encoder = encoder;
    this.repository = repository;
    this.cartUsecase = cartUsecase;
  }


  public void saveUserInfo(String username, String password) {
    if (repository.findByCredentialsUsername(username).isPresent()) {
      throw new RuntimeException("User with username: " + username + " already exist");
    }
    cartUsecase.createCart(username);
    repository.save(new UserInfo(username, encoder.encode(password)));
  }
}
