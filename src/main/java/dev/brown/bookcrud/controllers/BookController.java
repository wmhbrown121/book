package dev.brown.bookcrud.controllers;

import dev.brown.bookcrud.models.Book;
import dev.brown.bookcrud.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(@RequestParam(name = "author", required = false) String author,
                                               @RequestParam(name = "title", required = false) String title,
                                               @RequestParam(name = "condition", required = false) Integer condition){
        if(author!=null)
            return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooksByAuthor(author));
        else if(title!=null)
            return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooksByTitle(title));
        else if (condition != null)
            return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooksByCondition(condition));
        else
            return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookById(id));
    }

}
