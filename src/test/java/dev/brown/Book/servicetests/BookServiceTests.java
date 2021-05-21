package dev.brown.Book.servicetests;

import dev.brown.Book.models.Book;
import dev.brown.Book.services.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class BookServiceTests {

    @Autowired
    BookService bookService;

    @Test
    void get_book_by_id(){
        int id = 3;
        Book book = bookService.getBookById(id);
        Assertions.assertEquals(id,book.getBookId());
    }

    @Test
    void get_all_books(){
        List<Book> books = bookService.getAllBooks();
        Assertions.assertEquals(6,books.size());
    }

    @Test
    void get_books_by_title(){
        String title = "To Kill A Mockingbird";
        List<Book> books = bookService.getBooksByTitle(title);
        Assertions.assertEquals(2,books.size());
        for(Book b : books)
            Assertions.assertEquals(title,b.getTitle());

    }

    @Test
    void get_books_by_author(){
        String author = "J. K. Rowling";
        List<Book> books = bookService.getBooksByAuthor(author);
        Assertions.assertEquals(3,books.size());
        for(Book b : books)
            Assertions.assertEquals(author,b.getAuthor());

    }

    @Test
    void get_books_by_condition(){
        int condition = 2;
        List<Book> books = bookService.getBooksByCondition(condition);
        Assertions.assertEquals(4,books.size());
        for(Book b : books)
            Assertions.assertEquals(condition,b.getCondition());
    }

}
