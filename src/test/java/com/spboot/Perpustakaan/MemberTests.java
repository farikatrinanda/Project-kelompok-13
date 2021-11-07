/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.Perpustakaan;

import com.spboot.Perpustakaan.models.Member;
import com.spboot.Perpustakaan.repositories.MemberRepository;
import com.spboot.Perpustakaan.services.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author Gayatri Apsarini
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MemberTests {
    @InjectMocks
       @Autowired
       MemberService service;
    
        @Mock
        MemberRepository repository;
        @Autowired
        private MockMvc mockMvc;
        
    @Test
    public void testCreateMember() throws Exception{
        Member member = new Member ();
        member.setName("Rara");
        member.setAddress("jl Cendrawasih no 30");
        member.setPhone("01234567");
               
       service.mstore(member);
              
    }
         @Test
    public void createMemberWithEmptyName() throws Exception {
        Throwable e = null;
        String message = null;
        
        try {
            Member member = new Member();
            member.setName("");
            member.setAddress("jl Cendrawasih no 30");
            member.setPhone("01234567");
            
            when(repository.save(member))
                    .thenThrow(new Exception("please fill out this field"));
            service.mstore(member);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }
        
        Assertions.assertTrue(e instanceof Exception);
    }
    
    @Test
    public void createMemberWithEmptyAddress() throws Exception {
        Throwable e = null;
        String message = null;
        
        try {
            Member member = new Member();
            member.setName("Rara");
            member.setAddress("");
            member.setPhone("01234567");
            
            when(repository.save(member))
                    .thenThrow(new Exception("please fill out this field"));
            service.mstore(member);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }
        
        Assertions.assertTrue(e instanceof Exception);
    }
    
    @Test
    public void createMemberWithEmptyPhone() throws Exception {
        Throwable e = null;
        String message = null;
        
        try {
            Member member = new Member();
            member.setName("Rara");
            member.setAddress("jl Cendrawasih no 30");
            member.setPhone("");
            
            when(repository.save(member))
                    .thenThrow(new Exception("please fill out this field"));
            service.mstore(member);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }
        
        Assertions.assertTrue(e instanceof Exception);
    }
}
