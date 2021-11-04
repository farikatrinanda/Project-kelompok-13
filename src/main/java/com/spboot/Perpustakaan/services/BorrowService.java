/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.Perpustakaan.services;

import com.spboot.Perpustakaan.interfaces.BorrowInterface;
import com.spboot.Perpustakaan.models.Borrow;
import com.spboot.Perpustakaan.repositories.BorrowRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gayatri Apsarini
 */
@Service
public class BorrowService implements BorrowInterface{
     @Autowired
    private BorrowRepository borrowRepository;
    
    @Override
    public List<Borrow> getAll() {
        return borrowRepository.findAll();
    }

    @Override
    public void brstore(Borrow borrow) {
        this.borrowRepository.save(borrow);
    }
    
    @Override
    public Borrow getById(long id) {
        Optional < Borrow > optional = borrowRepository.findById(id);

     if (!optional.isPresent()) {
        throw new RuntimeException(" Borrow not found for id : " + id);
     }

    Borrow borrow = optional.get();
    return borrow;
    }

    @Override
    public void delete(long id) {
    this.borrowRepository.deleteById(id);
    }
}
