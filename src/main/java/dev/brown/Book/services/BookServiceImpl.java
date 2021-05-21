package dev.brown.Book.services;

import dev.brown.Book.models.Book;
import dev.brown.Book.repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepo bookRepo;

    @Override
    public Book getBookById(int id){
        return bookRepo.findById(id).orElse(null);
    }

    @Override
    public List<Book> getAllBooks() {
        return (List<Book>) bookRepo.findAll();
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return bookRepo.findBooksByAuthor(author);
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        return bookRepo.findBooksByTitle(title);
    }

    @Override
    public List<Book> getBooksByCondition(int condition) { return bookRepo.findBooksByCondition(condition); }
}
