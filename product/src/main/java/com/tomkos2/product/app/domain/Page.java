package com.tomkos2.product.app.domain;

import java.util.ArrayList;
import java.util.List;

public class Page {
    private List<Book> books = new ArrayList<>();

    public Page() {
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
