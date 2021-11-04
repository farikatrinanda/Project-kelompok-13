/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.Perpustakaan;

import com.spboot.Perpustakaan.models.User;
import com.spboot.Perpustakaan.repositories.UserRepository;
import com.spboot.Perpustakaan.services.UserService;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author Gayatri Apsarini
 */
@SpringBootTest
public class UserIntegrationTests {

    @InjectMocks
    @Autowired
    UserService service;

    @Mock
    UserRepository repository;

    @Test
    public void createUserTest() throws Exception {
        User user = new User();
        user.setEmail("nana@gmail.com");
        user.setName("nana");
        user.setPassword("123");

        when(repository.save(user)).thenReturn(user);
        service.register(user);

        when(repository.findByEmail("test@mail.com")).thenReturn(user);

        User checkUser = this.repository.findByEmail("test@mail.com");

        Assertions.assertEquals(user, checkUser);
    }

    @Test
    public void createUserTestWithEmptyName() throws Exception {
        
        try {
            String email = RandomString.make(10).toLowerCase() + "@mail.com";
            String password = RandomString.make(10).toLowerCase();
            User user = new User();
            user.setEmail(email);
            user.setName("");
            user.setPassword(password);

            when(repository.save(user))
                    .thenThrow(new IllegalArgumentException("Name cannot be null!"));
            
            service.register(user);
        } catch (Exception e) {
           Assertions.assertTrue(e instanceof Exception);
        Assertions.assertEquals("Name cannot be null!",e.getMessage());
        }
       
    }
            
 

    @Test
    public void createUserTestWithEmptyEmail() throws Exception {
          
        try {
            String password = RandomString.make(10).toLowerCase();
            User user = new User();
            user.setEmail("");
            user.setName("nana");
            user.setPassword(password);

            when(repository.save(user))
                    .thenThrow(new IllegalArgumentException("Email cannot be null!"));
            
            service.register(user);
        } catch (Exception e) {
            Assertions.assertTrue(e instanceof Exception);
        Assertions.assertEquals("Email cannot be null!", e.getMessage());
        }
       
    }
    
     @Test
    public void createUserTestWithEmptyPassword() throws Exception {
         
        try {
            String email = RandomString.make(10).toLowerCase() + "@mail.com";
            User user = new User();
            user.setEmail(email);
            user.setName("nana");
            user.setPassword("");

            when(repository.save(user))
                    .thenThrow(new IllegalArgumentException("Password cannot be null!"));
            
            service.register(user);
        } catch (Exception e) {
            Assertions.assertTrue(e instanceof Exception);
        Assertions.assertEquals("Password cannot be null!", e.getMessage());
            
        }
    }
}
