package com.tomkos2.monolith.app.user.config;

import com.tomkos2.monolith.app.user.domain.UserInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {

  private UserInfo userInfo;

  public UserPrincipal(UserInfo userInfo) {
    this.userInfo = userInfo;
  }

  @Override
  public Collection<GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("ROLE_" + this.userInfo.getRole().toString()));
    return authorities;
  }

  @Override
  public String getPassword() {
    return this.userInfo.getPassword();
  }

  @Override
  public String getUsername() {
    return this.userInfo.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
