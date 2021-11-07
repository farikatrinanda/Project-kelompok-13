/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.Perpustakaan;

import com.spboot.Perpustakaan.models.Book;
import com.spboot.Perpustakaan.models.Borrow;
import com.spboot.Perpustakaan.models.Member;
import com.spboot.Perpustakaan.models.Status;
import com.spboot.Perpustakaan.repositories.BorrowRepository;
import com.spboot.Perpustakaan.services.BorrowService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

/**
 *
 * @author Gayatri Apsarini
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BorrowTest {

    @InjectMocks
    @Autowired
    BorrowService service;

    @MockBean
    BorrowRepository repository;
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateBorrow() throws Exception {
        
        Member member = new Member();
        member.setId(1);
        
        Book book = new Book();
        book.setId(1);
        
        Status status = new Status();
        status.setId(1);
 
        Borrow borrow = new Borrow();
        
        borrow.setMember(member);
        borrow.setBook(book);
        borrow.setStatus(status);
        borrow.setDate_borrow("2020-12-11");
        borrow.setDue_date("2020-12-18");
        borrow.setDate_return("2020-12-20");

         service.brstore(borrow);
    } 

    @Test
    public void createBorrowWithEmptyDateBorrow() throws Exception {
        Throwable e = null;
        String message = null;

        try {
            Member member = new Member();
        member.setId(1);
        
        Book book = new Book();
        book.setId(1);
        
        Status status = new Status();
        status.setId(1);
        
        Borrow borrow = new Borrow();
        borrow.setMember(member);
        borrow.setBook(book);
        borrow.setStatus(status);
        borrow.setDate_borrow("");
        borrow.setDue_date("2020-12-18");
        borrow.setDate_return("2020-12-20");

            when(repository.save(borrow))
                    .thenThrow(new Exception("please fill out this field"));
            service.brstore(borrow);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }
        
  
        Assertions.assertTrue(e instanceof Exception);
    }



    @Test
    public void createBorrowWithEmptyDueDate() throws Exception {
        Throwable e = null;
        String message = null;

        try {
            Member member = new Member();
        member.setId(1);
        
        Book book = new Book();
        book.setId(1);
        
        Status status = new Status();
        status.setId(1);
        
        Borrow borrow = new Borrow();
        borrow.setMember(member);
        borrow.setBook(book);
        borrow.setStatus(status);
        borrow.setDate_borrow("2020-12-11");
        borrow.setDue_date("");
        borrow.setDate_return("2020-12-20");

            when(repository.save(borrow))
                    .thenThrow(new Exception("please fill out this field"));
            service.brstore(borrow);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }
        
        

        Assertions.assertTrue(e instanceof Exception);
    }
}




