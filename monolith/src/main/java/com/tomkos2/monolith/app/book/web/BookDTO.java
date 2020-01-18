package com.tomkos2.monolith.app.book.web;

public class BookDTO {

    private String isbn;
    private String title;
    private String subtitle;
    private double price;
    private String image;

    private BookDTO() {
    }

    public BookDTO(String isbn, String title, String subtitle, double price, String image) {
        this.isbn = isbn;
        this.title = title;
        this.subtitle = subtitle;
        this.price = price;
        this.image = image;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
