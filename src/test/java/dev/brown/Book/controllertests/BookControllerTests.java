package dev.brown.Book.controllertests;

import dev.brown.Book.models.Book;
import dev.brown.Book.services.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private BookService bookService;

    @Test
    void get_all_books() throws Exception {
        MvcResult result = mvc.perform(MockMvcRequestBuilders
                .get("/books")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    void get_book_by_id() throws Exception{
        int id = 2;
        MvcResult result = mvc.perform(MockMvcRequestBuilders
                .get("/books/"+id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    void get_books_by_author() throws Exception{
        String author = "J. K. Rowling";
        MvcResult result = mvc.perform(MockMvcRequestBuilders
                .get("/books?author="+author)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    void get_books_by_title() throws Exception{
        String title = "To Kill A Mockingbird";
        MvcResult result = mvc.perform(MockMvcRequestBuilders
                .get("/books?title="+title)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    void get_books_by_condition() throws Exception{
        int condition = 2;
        MvcResult result = mvc.perform(MockMvcRequestBuilders
                .get("/books?condition="+condition)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }
}
