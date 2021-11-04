/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.Perpustakaan.services;

import com.spboot.Perpustakaan.interfaces.StatusInterface;
import com.spboot.Perpustakaan.models.Status;
import com.spboot.Perpustakaan.repositories.StatusRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gayatri Apsarini
 */
@Service    
public class StatusService implements StatusInterface {

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public List<Status> getAll() {
        return statusRepository.findAll();
    }
}
