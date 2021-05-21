package dev.brown.Book.services;

import dev.brown.Book.models.Book;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();
    Book getBookById(int id);
    List<Book> getBooksByAuthor(String author);
    List<Book> getBooksByTitle(String title);
    List<Book> getBooksByCondition(int condition);

}
