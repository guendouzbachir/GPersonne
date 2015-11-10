/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import Entities.Person;
import Entities.Status;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author bibo
 */

@Stateless
public class PersonFacade implements RegisterI{
    @PersistenceContext(unitName = "GPersonPU")
    private EntityManager em;

   /* @Override
    protected EntityManager getEntityManager() {
        return em;
    }*/

    public PersonFacade() {
        //super(Person.class);
        //super(Address.class);
    }
    
    //@Override
    /*
    public void AddPerson(String firstname,String lastname,String nickname,String birthdate,String title,String fulltitle,Integer code,String town, Integer code_one,String town_one){
        Address address=new Address();
        Address address_t=new Address();
        Status status=new Status();
        Person person=new Person();
        
        Status s = getStatus(title, fulltitle);
        if(s != null) {
            status = s;
        }
        else{
            status.setTitle(title);
            status.setFullTitle(fulltitle);
        }
        
        address.setCode(code);
        address.setTown(town);
        address_t.setCode(code_one);
        address_t.setTown(town_one);
        
        
        person.setLastName(lastname);
        person.setNickName(nickname);
        person.setBirthDate(birthdate);
        
        status.addPerson(person);
        
        person.setStatus(status);
        person.addAddress(address);
        person.addAddress(address_t);
        
        address.setPerson(person);
        address_t.setPerson(person);
        //em.persist(person);
        em.persist(address_t);
        //em.persist(address_t);
        //em.persist(status);
        //return account;
    }*/
    
    @Override
    public void addPerson(String firstname,String lastname,String nickname,String birthdate,String title,String fulltitle){
        Status status=new Status();
        Person person=new Person();
        
        Status s = getStatus(title, fulltitle);
        if(s != null) {
            status = s;
        }
        else{
            status.setTitle(title);
            status.setFullTitle(fulltitle);
        }
        
        person.setFirstName(firstname);
        person.setLastName(lastname);
        person.setNickName(nickname);
        person.setBirthDate(birthdate);
        
        //em.persist(status);
        //status.addPerson(person);
        //person.setStatus(status);
        person.setStatus(status);
        em.persist(person);
     
        }      
    
    
    @Override
    public Status getStatus(String title, String fullTitle) {
        TypedQuery<Status> q = em.createNamedQuery("Status.getStatus",Status.class);
        q.setParameter("title", title);
        q.setParameter("fullTitle", fullTitle);
        Status s = null;
        try {
            s = q.getSingleResult();
        }catch(NoResultException ex) {
            
        }
        return s ;
    }
    
    @Override
    public Person find(Long id) {
        Person person =em.find(Person.class, id);
        return person;
    }
    
    
    

   // @Override

    protected EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   

    
    
    
}
