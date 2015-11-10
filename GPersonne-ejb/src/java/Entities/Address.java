/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import Entities.*;

/**
 *
 * @author bibo
 */
@Entity
public class Address implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "CODE")
    private Integer code;
    @Column(name = "TOWN")
    private String town;
    
    @ManyToMany
    private List<Person> persons;
    
    public Address() {
        persons =new  ArrayList<Person>();
    }
    
    
    
    public List<Person> getPerson() {
        return persons;
    }

    public void setPerson(List person) {
        this.persons = person;
    }
    
    public void addPerson(Person p){
        this.persons.add(p);
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
    
    
    
    
    
    
}

