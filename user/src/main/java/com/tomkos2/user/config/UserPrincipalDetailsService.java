package com.tomkos2.user.config;

import com.tomkos2.user.domain.UserInfo;
import com.tomkos2.user.usecase.LoadUserInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

  private final LoadUserInfo loadUserInfo;

  public UserPrincipalDetailsService(LoadUserInfo loadUserInfo) {
    this.loadUserInfo = loadUserInfo;
  }

  @Override
  public UserDetails loadUserByUsername(String username) {
    UserInfo userInfo = this.loadUserInfo.loadByUsername(username);
    return new UserPrincipal(userInfo);
  }
}
