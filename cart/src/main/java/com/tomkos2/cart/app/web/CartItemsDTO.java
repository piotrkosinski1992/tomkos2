package com.tomkos2.cart.app.web;

import java.util.List;

public class CartItemsDTO {

    private List<BookDTO> books;

    public CartItemsDTO() {
    }

    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }
}
