package dev.brown.Book.models;

import javax.persistence.*;

@Entity
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="book_id")
    private int bookId;

    @Column(name = "title")
    private String title;

    @Column(name="author")
    private String author;

    @Column(name="condition")
    private int condition;

    public Book() {}

    public Book(int bookId, String title, String author, int condition) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.condition = condition;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", condition=" + condition +
                '}';
    }
}
