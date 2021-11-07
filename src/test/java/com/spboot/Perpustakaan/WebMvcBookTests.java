/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.Perpustakaan;

import com.spboot.Perpustakaan.models.Book;
import com.spboot.Perpustakaan.models.User;
import java.util.HashMap;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
/**
 *
 * @author Gayatri Apsarini
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebMvcBookTests {
     @Autowired
    private MockMvc mockMvc;

    @Test
    public void testShowDashboard() throws Exception {

        String email = RandomString.make(10).toLowerCase() + "@mail.com";
        String password = RandomString.make(10).toLowerCase();

        User user = new User();
        user.setEmail(email);
        user.setName("Rara");
        user.setPassword(password);

        mockMvc.perform(post("/register")
                .flashAttr("user", user))
                .andExpect(status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/login"));

        User userLogin = new User();
        userLogin.setEmail(email);
        userLogin.setPassword(password);

        mockMvc.perform(post("/login")
                .flashAttr("user", userLogin))
                .andExpect(status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/"))
                .andDo(print());

        HashMap<String, Object> sessionattr = new HashMap<String, Object>();

        sessionattr.put("id", user.getId());
        sessionattr.put("email", user.getEmail());
        sessionattr.put("name", user.getName());
        sessionattr.put("loggedIn", true);

        mockMvc.perform(get("/")
                .sessionAttrs(sessionattr))
                .andExpect(status().isOk());
    }
    
    @Test
    public void testCreateBook() throws Exception {

        String email = RandomString.make(10).toLowerCase() + "@mail.com";
        String password = RandomString.make(10).toLowerCase();

        User user = new User();
        user.setEmail(email);
        user.setName("Rara");
        user.setPassword(password);

        mockMvc.perform(post("/register")
                .flashAttr("user", user))
                .andExpect(status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/login"));

        User userLogin = new User();
        userLogin.setEmail(email);
        userLogin.setPassword(password);

        mockMvc.perform(post("/login")
                .flashAttr("user", userLogin))
                .andExpect(status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/"));

        HashMap<String, Object> sessionattr = new HashMap<String, Object>();

        sessionattr.put("id", user.getId());
        sessionattr.put("email", user.getEmail());
        sessionattr.put("name", user.getName());
        sessionattr.put("loggedIn", true);

        mockMvc.perform(get("/")
                .sessionAttrs(sessionattr))
                .andExpect(status().isOk());
        
        mockMvc.perform(get("/book/bcreate")
                .sessionAttrs(sessionattr))
                .andExpect(status().isOk());
                
        
            Book book = new Book();
            book.setTitle("Hai Miiko");
            book.setAuthor("Eriko Ono");
            book.setPublisher("m&c");
        
        mockMvc.perform(post("/book/bstore")
                .sessionAttrs(sessionattr)
                .flashAttr("book", book))
                .andExpect(status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/book"))
                .andDo(print());
    }
}

