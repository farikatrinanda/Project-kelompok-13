/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.Perpustakaan;

import com.spboot.Perpustakaan.models.User;
import java.util.HashMap;
import net.bytebuddy.utility.RandomString;
import static org.hamcrest.Matchers.containsString;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author Gayatri Apsarini
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebMvcRegisterTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRegisterWithRightCredentials() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk());
                

        String email = RandomString.make(20).toLowerCase() + "@mail.com";
        String password = RandomString.make(20).toLowerCase();

        User user = new User();
        user.setEmail(email);
        user.setName("Nana");
        user.setPassword(password);

        mockMvc.perform(post("/register")
                .flashAttr("user", user))
                .andExpect(status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/login"));
    }

    @Test
    public void testRegisterWithoutName() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk());
                

        String email = RandomString.make(20).toLowerCase() + "@mail.com";
        String password = RandomString.make(20).toLowerCase();

        User user = new User();
        user.setEmail(email);
        user.setName("");
        user.setPassword(password);

        mockMvc.perform(post("/register")
                .flashAttr("user", user))
                .andExpect(status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/register"))
                .andExpect(MockMvcResultMatchers
                        .flash().attributeExists("danger")
                )
                .andExpect(
                        MockMvcResultMatchers
                                .flash()
                                .attribute("danger", "Name cannot be null!")
                );
    }
    
    @Test
    public void testRegisterWithoutEmail() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk());
                

        String email = RandomString.make(20).toLowerCase() + "@mail.com";
        String password = RandomString.make(20).toLowerCase();

        User user = new User();
        user.setEmail("");
        user.setName("nana");
        user.setPassword(password);

        mockMvc.perform(post("/register")
                .flashAttr("user", user))
                .andExpect(status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/register"))
                .andExpect(MockMvcResultMatchers
                        .flash().attributeExists("danger")
                )
                .andExpect(
                        MockMvcResultMatchers
                                .flash()
                                .attribute("danger", "Email cannot be null!")
                );
    }
    
    @Test
    public void testRegisterWithoutPassword() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk());
                

        String email = RandomString.make(20).toLowerCase() + "@mail.com";
        String password = RandomString.make(20).toLowerCase();

        User user = new User();
        user.setEmail(email);
        user.setName("nana");
        user.setPassword("");

        mockMvc.perform(post("/register")
                .flashAttr("user", user))
                .andExpect(status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/register"))
                .andExpect(MockMvcResultMatchers
                        .flash().attributeExists("danger")
                )
                .andExpect(
                        MockMvcResultMatchers
                                .flash()
                                .attribute("danger", "Password cannot be null!")
                );
    }
}
