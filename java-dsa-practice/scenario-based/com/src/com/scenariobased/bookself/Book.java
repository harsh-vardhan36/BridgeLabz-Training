package com.scenariobased.bookself;

class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public boolean equals(Object o) {
        Book b = (Book) o;
        return this.title.equals(b.title) && this.author.equals(b.author);
    }

    public int hashCode() {
        return (title + author).hashCode();
    }

    public String toString() {
        return title + " by " + author;
    }
}

