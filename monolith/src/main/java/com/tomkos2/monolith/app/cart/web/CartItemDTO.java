package com.tomkos2.monolith.app.cart.web;

import com.tomkos2.monolith.app.book.domain.BookDetails;
import com.tomkos2.monolith.app.book.web.BookDTO;
import java.math.BigDecimal;

public class CartItemDTO {

  private BookDTO book;
  private Long amount;

  private CartItemDTO() {
  }

  public CartItemDTO(BookDetails bookDetails, Long amount) {
    this.book = convertToDTO(bookDetails);
    this.amount = amount;
  }

  private BookDTO convertToDTO(BookDetails bookDetails) {
    return new BookDTO(
        bookDetails.getIsbn(),
        bookDetails.getTitle(),
        bookDetails.getSubtitle(),
        preparePrice(bookDetails.getPrice()),
        bookDetails.getImage()
    );
  }

  private double preparePrice(String price) {
    String priceWithoutCurrency = price.substring(1, price.length() -1);
    return Double.parseDouble(priceWithoutCurrency);
  }

  public BookDTO getBook() {
    return book;
  }

  public Long getAmount() {
    return amount;
  }

  public void setBook(BookDTO book) {
    this.book = book;
  }

  public void setAmount(Long amount) {
    this.amount = amount;
  }
}
