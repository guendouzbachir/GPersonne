/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author bibo
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 *
 * @author fromenti1u
 */
@Entity
@NamedQueries(
        @NamedQuery(name="Status.getStatus",
                    query="SELECT s FROM Status s WHERE s.title = :title AND s.fullTitle = :fullTitle")
)
public class Status implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDSTATUS")
    private Integer id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "FULLTITLE")
    private String fullTitle; 
    @OneToMany()
    private List<Person> person;
    
    public Status() {
        this.title = "";
        this.fullTitle = "";
        this.person = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }
    
    public void addPerson(Person p) {
        this.person.add(p);
    }
    
    public List<Person> getPersons() {
        return this.person;
    }
    
    public boolean contains(Person p)
    {
        return person.contains(p);
    }

}
