/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.Perpustakaan.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Gayatri Apsarini
 */
@Entity
@Table (name="borrow")
public class Borrow {
    @Id 
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne
    @JoinColumn(name="id_member")
    private Member member;
    
    @ManyToOne
    @JoinColumn(name="id_book")
    private Book book;
    
    @ManyToOne
    @JoinColumn(name ="id_status")
    private Status status;
    
    @Column(name="date_borrow")
    private String date_borrow;
    
    @Column(name="due_date")
    private String due_date;
    
    @Column(name="date_return")
    private String date_return;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDate_borrow() {
        return date_borrow;
    }

    public void setDate_borrow(String date_borrow) {
        this.date_borrow = date_borrow;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public String getDate_return() {
        return date_return;
    }

    public void setDate_return(String date_return) {
        this.date_return = date_return;
    }

    
}
