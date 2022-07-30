package com.ironhack.proxybooksservice.models;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Book {

    @Id
    @NotNull
    private Long ean;
    private String title;
    private String author;
    private String genre;
    private int pagNumber;
    @Column(name = "lang")
    private String language;
    private int publicationYear;
    private String publisher;
    @Column(name = "url")
    private String image;
    private String plot;

    public Book() {
    }

    public Book(Long ean, String title, String author, String genre, int pagNumber, String language,
                int publicationYear, String publisher, String image, String plot) {
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

    public int getPagNumber() {
        return pagNumber;
    }

    public void setPagNumber(int pagNumber) {
        this.pagNumber = pagNumber;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
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
