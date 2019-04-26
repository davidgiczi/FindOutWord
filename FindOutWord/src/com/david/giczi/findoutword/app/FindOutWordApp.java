package com.david.giczi.findoutword.app;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.david.giczi.findoutword.model.Result;
import com.david.giczi.findoutword.view.ControlPanel;


public class FindOutWordApp {

	public static void main(String[] args) {
		
		//new ControlPanel();
	
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("FindOutWord");
		
		EntityManager em=emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(new Result("Localhero", "apple", 66, 26));
		
		em.getTransaction().commit();
		
		em.close();
		
		emf.close();
		
	}

}
