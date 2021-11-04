/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.Perpustakaan.interfaces;

import com.spboot.Perpustakaan.models.Borrow;
import java.util.List;

/**
 *
 * @author Gayatri Apsarini
 */
public interface BorrowInterface {
    List<Borrow> getAll();
    void brstore(Borrow borrow);
    Borrow getById(long id);
    void delete(long id);
    
}
