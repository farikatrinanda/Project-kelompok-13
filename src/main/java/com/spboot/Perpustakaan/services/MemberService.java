/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.Perpustakaan.services;

import com.spboot.Perpustakaan.interfaces.MemberInterface;
import com.spboot.Perpustakaan.models.Member;
import com.spboot.Perpustakaan.repositories.MemberRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gayatri Apsarini
 */
@Service
public class MemberService implements MemberInterface {
    @Autowired
    private MemberRepository memberRepository;
    
    @Override
    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    @Override
    public void mstore(Member member) {
        this.memberRepository.save(member);
    }
    
    @Override
    public Member getById(long id) {
        Optional < Member > optional = memberRepository.findById(id);

     if (!optional.isPresent()) {
        throw new RuntimeException(" Member not found for id : " + id);
     }

    Member member = optional.get();
    return member;
    }

    @Override
    public void delete(long id) {
    this.memberRepository.deleteById(id);
    }
}
