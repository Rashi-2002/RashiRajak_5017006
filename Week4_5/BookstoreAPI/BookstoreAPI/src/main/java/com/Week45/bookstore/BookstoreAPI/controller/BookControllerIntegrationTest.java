package com.Week45.bookstore.BookstoreAPI.controller;



import com.Week45.bookstore.BookstoreAPI.model.Book;
import com.Week45.bookstore.BookstoreAPI.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ActiveProfiles("test")
public class BookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository.deleteAll();
    }

    @Test
    public void testCreateBook() throws Exception {
        Book book = new Book(null, "Title", "Author", 20.0, "ISBN1234");

        mockMvc.perform(post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(book)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Title"));
    }

    @Test
    public void testGetBook() throws Exception {
        Book book = bookRepository.save(new Book(null, "Title", "Author", 20.0, "ISBN1234"));

        mockMvc.perform(get("/books/" + book.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Title"));
    }

    @Test
    public void testGetAllBooks() throws Exception {
        bookRepository.save(new Book(null, "Title", "Author", 20.0, "ISBN1234"));

        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Title"));
    }

    @Test
    public void testUpdateBook() throws Exception {
        Book book = bookRepository.save(new Book(null, "Title", "Author", 20.0, "ISBN1234"));
        book.setTitle("Updated Title");

        mockMvc.perform(put("/books/" + book.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(book)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated Title"));
    }

    @Test
    public void testDeleteBook() throws Exception {
        Book book = bookRepository.save(new Book(null, "Title", "Author", 20.0, "ISBN1234"));

        mockMvc.perform(delete("/books/" + book.getId()))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/books/" + book.getId()))
                .andExpect(status().isNotFound());
    }
}
