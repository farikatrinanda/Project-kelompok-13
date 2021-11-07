/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.Perpustakaan;

import com.spboot.Perpustakaan.models.Book;
import com.spboot.Perpustakaan.repositories.BookRepository;
import com.spboot.Perpustakaan.services.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author Gayatri Apsarini
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookTest {

    @InjectMocks
    @Autowired
    BookService service;

    @MockBean
    BookRepository repository;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateBook() throws Exception {

        Book book = new Book();
        book.setTitle("Hai Miiko");
        book.setAuthor("Eriko Ono");
        book.setPublisher("m&c");

        service.bstore(book);

    }

    @Test
    public void createBookWithEmptyTitle() throws Exception {
        Throwable e = null;
        String message = null;

        try {
            Book book = new Book();
            book.setTitle("");
            book.setAuthor("Eriko Ono");
            book.setPublisher("m&c");

            when(repository.save(book))
                    .thenThrow(new Exception("please fill out this field"));
            service.bstore(book);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }

        Assertions.assertTrue(e instanceof Exception);
    }
    
    @Test
    public void createBookWithEmptyAuthor() throws Exception {
        Throwable e = null;
        String message = null;

        try {
            Book book = new Book();
            book.setTitle("Hai Miiko");
            book.setAuthor("");
            book.setPublisher("m&c");

            when(repository.save(book))
                    .thenThrow(new Exception("please fill out this field"));
            service.bstore(book);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }

        Assertions.assertTrue(e instanceof Exception);
    }
    
    @Test
    public void createBookWithEmptyPublisher() throws Exception {
        Throwable e = null;
        String message = null;

        try {
            Book book = new Book();
            book.setTitle("Hai Miiko");
            book.setAuthor("Eriko Ono");
            book.setPublisher("");

            when(repository.save(book))
                    .thenThrow(new Exception("please fill out this field"));
            service.bstore(book);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }

        Assertions.assertTrue(e instanceof Exception);
    }
}
