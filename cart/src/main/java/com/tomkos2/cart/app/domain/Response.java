package com.tomkos2.cart.app.domain;

public class Response {
  private boolean isSuccess;
  private String message;

  public Response() {
  }

  public boolean isSuccess() {
    return isSuccess;
  }

  public String getMessage() {
    return message;
  }

  public void setSuccess(boolean success) {
    isSuccess = success;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
