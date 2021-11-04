/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.Perpustakaan.controllers;

import com.spboot.Perpustakaan.interfaces.BookInterface;
import com.spboot.Perpustakaan.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Gayatri Apsarini
 */
@Controller
public class BookController {
     @Autowired
    private BookInterface bookInterface;

    @GetMapping("/book")
    public String bindex(Model model) {
        model.addAttribute("list", bookInterface.getAll());
        return "book/bindex";
    }

    @GetMapping("/book/bcreate")
    public String bcreate(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        
        return "book/bcreate";
    }

    @PostMapping("/book/bstore")
    public String bstore(@ModelAttribute("book") Book book) {
        bookInterface.bstore(book);
        return "redirect:/book";
    }
    
    @GetMapping("/book/{id}/bedit")
    public String bedit(@PathVariable(value = "id") long id, Model model) {
        Book book = bookInterface.getById(id);

        model.addAttribute("book", book);
        return "book/bedit";
    }

    @PostMapping("/book/{id}/delete")
    public String delete(@PathVariable(value = "id") long id) {
        bookInterface.delete(id);
        return "redirect:/book" ;
    }
}
