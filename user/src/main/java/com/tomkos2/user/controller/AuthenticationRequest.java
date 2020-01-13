package com.tomkos2.user.controller;

import java.io.Serializable;

class AuthenticationRequest implements Serializable {

  private static final long serialVersionUID = -8445943548965154778L;

  private String username;
  private String password;

  private AuthenticationRequest() {
  }

  String getUsername() {
    return this.username;
  }

  String getPassword() {
    return this.password;
  }

  void setUsername(String username) {
    this.username = username;
  }

  void setPassword(String password) {
    this.password = password;
  }
}
