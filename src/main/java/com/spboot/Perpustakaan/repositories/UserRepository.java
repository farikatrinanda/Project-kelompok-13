/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.Perpustakaan.repositories;

import com.spboot.Perpustakaan.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Gayatri Apsarini
 */
public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);
}
