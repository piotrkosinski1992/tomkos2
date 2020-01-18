package com.tomkos2.monolith.app.inventory.domain;

public class Response {

  private boolean isSuccess;
  private String message;

  public Response() {
  }

  private Response(boolean isSuccess) {
    this.isSuccess = isSuccess;
  }

  private Response(boolean isSuccess, String message) {
    this.isSuccess = isSuccess;
    this.message = message;
  }

  public static Response Ok() {
    return new Response(true);
  }

  public static Response Error(String message) {
    return new Response(false, message);
  }

  public String getMessage() {
    return message;
  }

  public boolean isSuccess() {
    return isSuccess;
  }

  public void setSuccess(boolean success) {
    isSuccess = success;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
