/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.Perpustakaan.controllers;

import com.spboot.Perpustakaan.interfaces.BookInterface;
import com.spboot.Perpustakaan.interfaces.BorrowInterface;
import com.spboot.Perpustakaan.interfaces.MemberInterface;
import com.spboot.Perpustakaan.interfaces.StatusInterface;
import com.spboot.Perpustakaan.models.Book;
import com.spboot.Perpustakaan.models.Borrow;
import com.spboot.Perpustakaan.models.Member;
import com.spboot.Perpustakaan.models.Status;
import java.util.List;
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
public class BorrowController {
    @Autowired
    private BorrowInterface borrowInterface;

    @Autowired
    private MemberInterface memberInterface;
    
    @Autowired
    private BookInterface bookInterface;
    
    @Autowired
    private StatusInterface statusInterface;
    
    @GetMapping("/borrow")
    public String brindex(Model model) {
        model.addAttribute("list", borrowInterface.getAll());
        return "borrow/brindex";
    }

    @GetMapping("/borrow/brcreate")
    public String brcreate(Model model) {
        List<Member> member = memberInterface.getAll();
        model.addAttribute("member", member);
        
        List<Book> book = bookInterface.getAll();
        model.addAttribute("book", book);
        
        List<Status> status = statusInterface.getAll();
        model.addAttribute("status", status);
        
        Borrow borrow = new Borrow();
        model.addAttribute("borrow", borrow);
        
        return "borrow/brcreate";
    }

    @PostMapping("/borrow/brstore")
    public String brstore(@ModelAttribute("borrow") Borrow borrow) {
        borrowInterface.brstore(borrow);
        return "redirect:/borrow";
    }
    
    @GetMapping("/borrow/{id}/bredit")
    public String bredit(@PathVariable(value = "id") long id, Model model) {
        List<Member> member = memberInterface.getAll();
        model.addAttribute("member", member);
        
        List<Book> book = bookInterface.getAll();
        model.addAttribute("book", book);
        
        List<Status> status = statusInterface.getAll();
        model.addAttribute("status", status);
        
        Borrow borrow = borrowInterface.getById(id);

        model.addAttribute("borrow", borrow);
        return "borrow/bredit";
    }

    @PostMapping("/borrow/{id}/delete")
    public String delete(@PathVariable(value = "id") long id) {
        borrowInterface.delete(id);
        return "redirect:/borrow" ;
    }
}
