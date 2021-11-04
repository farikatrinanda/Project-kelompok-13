/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.Perpustakaan.controllers;

import com.spboot.Perpustakaan.interfaces.MemberInterface;
import com.spboot.Perpustakaan.models.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Gayatri Apsarini
 */
@Controller
public class MemberController {
    @Autowired
    private MemberInterface memberInterface;

    @GetMapping("/member")
    public String mindex(Model model) {
        model.addAttribute("list", memberInterface.getAll());
        return "member/mindex";
    }

    @GetMapping("/member/mcreate")
    public String mcreate(Model model) {
        Member member = new Member();
        model.addAttribute("member", member);
        
        return "member/mcreate";
    }

    @PostMapping("/member/mstore")
    public String mstore(@ModelAttribute("member") Member member) {
        memberInterface.mstore(member);
        return "redirect:/member";
    }
    
    @GetMapping("/member/{id}/medit")
    public String medit(@PathVariable(value = "id") long id, Model model) {
        Member member = memberInterface.getById(id);

        model.addAttribute("member", member);
        return "member/medit";
    }

    @PostMapping("/member/{id}/delete")
    public String delete(@PathVariable(value = "id") long id) {
        memberInterface.delete(id);
        return "redirect:/member" ;
    }
}
