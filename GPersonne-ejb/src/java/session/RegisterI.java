/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import Entities.*;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @author bibo
 */
@Local
public interface RegisterI {
    
    public void addPerson(String firstname,String lastname,String nickname,String birthdate,String title,String fulltitle);
    public Status getStatus(String title, String fullTitle);
    public Person find(Long id);
}
