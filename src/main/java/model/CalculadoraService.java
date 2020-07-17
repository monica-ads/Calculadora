/*
** This file contains the persistence class.
** Each class attribute is known as persistence attribute
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author fabricio
 */

public class CalculadoraService { //persistence class
  
	public List<Calculadora> list(){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");        
            EntityManager em = emf.createEntityManager();
            List<Calculadora> registro = null;
            Query query = em.createQuery("SELECT c FROM calculadora c "); 
            registro = query.getResultList();
            em.close();
            emf.close();
            return registro;            
      }
      
}
