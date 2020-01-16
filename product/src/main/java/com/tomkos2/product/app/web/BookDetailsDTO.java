package com.tomkos2.product.app.web;

import java.util.HashMap;
import java.util.Map;

public class BookDetailsDTO {

    private String isbn;
    private String title;
    private String subtitle;
    private String price;
    private String image;
    private String detailsAuthors;
    private String detailsPublisher;
    private int detailsPages;
    private int detailsYear;
    private int detailsRating;
    private String detailsDesc;
    public Map<String, String> detailsPdf = new HashMap<>();

    public BookDetailsDTO() {
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

    public String getDetailsAuthors() {
        return detailsAuthors;
    }

    public void setDetailsAuthors(String detailsAuthors) {
        this.detailsAuthors = detailsAuthors;
    }

    public String getDetailsPublisher() {
        return detailsPublisher;
    }

    public void setDetailsPublisher(String detailsPublisher) {
        this.detailsPublisher = detailsPublisher;
    }

    public int getDetailsPages() {
        return detailsPages;
    }

    public void setDetailsPages(int detailsPages) {
        this.detailsPages = detailsPages;
    }

    public int getDetailsYear() {
        return detailsYear;
    }

    public void setDetailsYear(int detailsYear) {
        this.detailsYear = detailsYear;
    }

    public int getDetailsRating() {
        return detailsRating;
    }

    public void setDetailsRating(int detailsRating) {
        this.detailsRating = detailsRating;
    }

    public String getDetailsDesc() {
        return detailsDesc;
    }

    public void setDetailsDesc(String detailsDesc) {
        this.detailsDesc = detailsDesc;
    }

    public Map<String, String> getDetailsPdf() {
        return detailsPdf;
    }

    public void setDetailsPdf(Map<String, String> detailsPdf) {
        this.detailsPdf = detailsPdf;
    }
}
