package com.tomkos2.inventory.app.domain;

public class Book {

    private String isbn;
    private Long amount;

    private Book() {
    }

    public Book(String isbn, Long amount) {
        this.isbn = isbn;
        this.amount = amount;
    }

    public String getIsbn() {
        return isbn;
    }

    public Long getAmount() {
        return amount;
    }

    public boolean decreaseAmount(Long amount) {
        if (this.amount < amount) {
            return false;
        }
        this.amount -= amount;
        return true;
    }

}
