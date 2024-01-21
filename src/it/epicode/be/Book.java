package it.epicode.be;

public class Book extends Element {
    private String author;
    private String type;

    public Book(String isbn, String title, int year, int pages, String author, String type) {
        super(isbn, title, year, pages);
        this.author = author;
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Author: " + author +
                ", Type: " + type;
    }
}
