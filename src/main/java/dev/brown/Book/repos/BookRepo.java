package dev.brown.Book.repos;

import dev.brown.Book.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface BookRepo extends CrudRepository<Book,Integer> {

    List<Book> findBooksByTitle(String title);
    List<Book> findBooksByAuthor(String author);
    List<Book> findBooksByCondition(int condition);
}
