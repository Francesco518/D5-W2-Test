package it.epicode.be;

import java.io.Serializable;

public abstract class Element implements Serializable {
    private String isbn;
    private String title;
    private int year;
    private int pages;

    public Element(String isbn, String title, int year, int pages) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.pages = pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn +
                ", Title: " + title +
                ", Year: " + year +
                ", Pages: " + pages;
    }
}

