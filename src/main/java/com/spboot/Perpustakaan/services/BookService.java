/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.Perpustakaan.services;

import com.spboot.Perpustakaan.interfaces.BookInterface;
import com.spboot.Perpustakaan.models.Book;
import com.spboot.Perpustakaan.repositories.BookRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gayatri Apsarini
 */
@Service
public class BookService implements BookInterface{
    @Autowired
    private BookRepository bookRepository;
    
    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public void bstore(Book book) {
        this.bookRepository.save(book);
    }
    
    @Override
    public Book getById(long id) {
        Optional < Book > optional = bookRepository.findById(id);

     if (!optional.isPresent()) {
        throw new RuntimeException(" Book not found for id : " + id);
     }

    Book book = optional.get();
    return book;
    }

    @Override
    public void delete(long id) {
    this.bookRepository.deleteById(id);
    }
}
