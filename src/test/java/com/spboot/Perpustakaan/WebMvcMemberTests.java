package com.spboot.Perpustakaan;

import com.spboot.Perpustakaan.models.Member;
import com.spboot.Perpustakaan.models.User;
import java.util.HashMap;
import net.bytebuddy.utility.RandomString;
import static org.hamcrest.Matchers.containsString;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 *
 * @author Hudya
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebMvcMemberTests {

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
    public void testCreateMember() throws Exception {

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
        
        mockMvc.perform(get("/member/mcreate")
                .sessionAttrs(sessionattr))
                .andExpect(status().isOk());
                
        
         Member member = new Member();
            member.setName("Rara");
            member.setAddress("jl Cendrawasih no 30");
            member.setPhone("01234567");
        
        mockMvc.perform(post("/member/mstore")
                .sessionAttrs(sessionattr)
                .flashAttr("member", member))
                .andExpect(status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/member"))
                .andDo(print());
    }
}