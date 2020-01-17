package com.tomkos2.book.app.domain;

import java.util.HashMap;
import java.util.Map;

public class BookDetails {

    private String authors;
    private String publisher;
    private int pages;
    private int year;
    private int rating;
    private String desc;
    Map<String, String> pdf = new HashMap<>();

    public BookDetails() {
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Map<String, String> getPdf() {
        return pdf;
    }

    public void setPdf(Map<String, String> pdf) {
        this.pdf = pdf;
    }
}
