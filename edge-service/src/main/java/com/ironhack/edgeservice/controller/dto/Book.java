package com.ironhack.edgeservice.controller.dto;

import javax.persistence.Column;
import java.time.LocalDate;

public class Book {
    private Long ean;
    private String title;
    private String author;
    private String genre;
    private String pagNumber;
    private String language;
    private LocalDate publicationYear;
    private String publisher;
    private String image;
    private String plot;

    public Book() {
    }

    public Book(Long ean, String title, String author, String genre, String pagNumber, String language,
                LocalDate publicationYear, String publisher, String image, String plot) {
        this.ean = ean;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pagNumber = pagNumber;
        this.language = language;
        this.publicationYear = publicationYear;
        this.publisher = publisher;
        this.image = image;
        this.plot = plot;
    }

    public Long getEan() {
        return ean;
    }

    public void setEan(Long ean) {
        this.ean = ean;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPagNumber() {
        return pagNumber;
    }

    public void setPagNumber(String pagNumber) {
        this.pagNumber = pagNumber;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public LocalDate getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(LocalDate publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }
}
