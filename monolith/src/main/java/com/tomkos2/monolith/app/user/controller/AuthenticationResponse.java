package com.tomkos2.monolith.app.user.controller;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

  private static final long serialVersionUID = 1250166508152483573L;

  private final String token;

  AuthenticationResponse(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }
}
