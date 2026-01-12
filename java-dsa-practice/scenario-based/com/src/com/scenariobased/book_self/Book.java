package com.scenariobased.book_self;

public class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    @Override
    public String toString() {
        return title + " by " + author;
    }

    // Used by HashSet to avoid duplicates
    @Override
    public boolean equals(Object obj) {
        Book b = (Book) obj;
        return this.title.equals(b.title) && this.author.equals(b.author);
    }

    @Override
    public int hashCode() {
        return (title + author).hashCode();
    }
}
