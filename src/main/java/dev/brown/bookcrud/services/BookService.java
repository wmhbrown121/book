package dev.brown.bookcrud.services;

import dev.brown.bookcrud.models.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();
    Book getBookById(int id);
    List<Book> getBooksByAuthor(String author);
    List<Book> getBooksByTitle(String title);
    List<Book> getBooksByCondition(int condition);

}
