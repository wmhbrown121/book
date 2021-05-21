package dev.brown.Book.repotests;

import dev.brown.Book.models.Book;
import dev.brown.Book.repos.BookRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookRepoTests {

    @Autowired
    BookRepo bookRepo;

    @Test
    void get_all_books(){
        List<Book> books = (List<Book>) bookRepo.findAll();
        Assertions.assertEquals(6,books.size());
    }

    @Test
    void get_book_by_id(){
        int id = 2;
        Book book = bookRepo.findById(id).orElse(null);
        Assertions.assertEquals(id,book.getBookId());
    }

    @Test
    void get_books_by_title(){
        String title = "To Kill A Mockingbird";
        List<Book> books = bookRepo.findBooksByTitle(title);
        Assertions.assertEquals(2,books.size());
        for(Book b : books)
            Assertions.assertEquals(title, b.getTitle());

    }

    @Test
    void get_books_by_author(){
        String author = "J. K. Rowling";
        List<Book> books = bookRepo.findBooksByAuthor(author);
        Assertions.assertEquals(3,books.size());
        for(Book b : books)
            Assertions.assertEquals(author,b.getAuthor());
    }

    @Test
    void get_books_by_condition(){
        int condition = 2;
        List<Book> books = bookRepo.findBooksByCondition(condition);
        Assertions.assertEquals(4,books.size());
        for(Book b : books)
            Assertions.assertEquals(condition,b.getCondition());
    }

}
