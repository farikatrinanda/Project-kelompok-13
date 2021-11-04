/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.Perpustakaan.interfaces;


import com.spboot.Perpustakaan.models.Book;
import java.util.List;

/**
 *
 * @author Gayatri Apsarini
 */
public interface BookInterface {
    List<Book> getAll();
    void bstore(Book book);
    Book getById(long id);
    void delete(long id);
}
