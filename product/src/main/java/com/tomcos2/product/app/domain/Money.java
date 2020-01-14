package com.tomcos2.product.app.domain;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Money {

  @Column(name = "PRICE")
  private BigDecimal value;

  public Money() {
  }

  public Money(double value) {
    this.value = new BigDecimal(value);
  }

  public BigDecimal getValue() {
    return value;
  }

  public String getStringValue() {
    return value.toString();
  }
}
