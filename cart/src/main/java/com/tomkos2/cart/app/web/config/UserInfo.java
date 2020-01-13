package com.tomkos2.cart.app.web.config;

import java.util.Objects;

public class UserInfo {
  private String username;

  UserInfo() {
  }

  public UserInfo(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserInfo userInfo = (UserInfo) o;
    return username.equals(userInfo.username);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username);
  }
}
