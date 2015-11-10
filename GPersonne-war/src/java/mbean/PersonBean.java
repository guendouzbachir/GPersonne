package mbean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Entities.Person;
import java.util.Random;
import session.PersonFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.validation.constraints.Pattern;
import session.RegisterI;


/**
 *
 * @author bibo
 */
@ManagedBean
@RequestScoped
public class PersonBean {

    @EJB
    RegisterI facade;
    
    private String firstName;
    private String lastName;
    //@Pattern( regexp = "dd-MM-yyyy", message = "Invalid birthday ex: dd-MM-yyyy" )
    private String birthDate;
    private String title;
    private String fulltitle;
    private Integer code;
    private String town;
    private Integer code_t;
    private String town_t;
    private Person person;
    
    private Long personId;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getPresonId() {
        return personId;
    }

    public void setPresonId(Long personId) {
        this.personId = personId;
    }
    /*
    public Integer getCode_t() {
        return code_t;
    }

    public void setCode_t(Integer code_t) {
        this.code_t = code_t;
    }

    public String getTown_t() {
        return town_t;
    }

    public void setTown_t(String town_t) {
        this.town_t = town_t;
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
    */

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFulltitle() {
        return fulltitle;
    }

    public void setFulltitle(String fulltitle) {
        this.fulltitle = fulltitle;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
   
    

    
    

    
    
    /**
     * Creates a new instance of AccountBean
     */
    public PersonBean() {
        person=new Person();
    }
    
    public String generateNickName() {
        Random r = new Random();
        return getLastName() + r.nextInt();
    }
    
    /*public String actionMethod()  {
        
        facade.AddPerson(getFirstName(),getLastName(),generateNickName(),getBirthDate(),getTitle(),getFulltitle(),getCode(),getTown(),getCode_t(),getTown_t());
        return "response";
    }*/
    
    public String addPersonStatus()  {
        
        facade.addPerson(getFirstName(),getLastName(),generateNickName(),getBirthDate(),getTitle(),getFulltitle());
        return "response";
    }
    
    
    public String actionFind(){      
        person=(Person) facade.find(getPresonId());
        setFirstName(person.getFirstName());
        setLastName(person.getLastName());
        setBirthDate(person.getBirthDate());
        setTitle(person.getStatus().getTitle());
        setFulltitle(person.getStatus().getFullTitle());
        return "result";
    }
}
