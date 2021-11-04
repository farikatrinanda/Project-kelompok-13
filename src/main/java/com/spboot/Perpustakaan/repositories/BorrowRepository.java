/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.Perpustakaan.repositories;

import com.spboot.Perpustakaan.models.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Gayatri Apsarini
 */
@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long>{
    
}
