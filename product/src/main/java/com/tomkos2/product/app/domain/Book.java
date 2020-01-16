package com.tomkos2.product.app.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {

    @JsonProperty("isbn13")
    private String isbn;
    private String title;
    private String subtitle;
    private String price;
    private String image;
    private BookDetails details;

    public Book() {
    }

    public BookDetails getDetails() {
        return details;
    }

    public void setDetails(BookDetails details) {
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
