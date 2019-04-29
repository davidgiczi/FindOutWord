package com.david.giczi.findoutword.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DataBaseOperations {

	
	private static DataBaseOperations db;
	
	
	private DataBaseOperations() {
		
	}
	
	
	public static DataBaseOperations getInstance() {
		
		if(db==null) {
			db=new DataBaseOperations();
		}
		
		return db;
	}
	
	
	public void insert(String playerName, String theWord, int secCounter, int clickCounter, String date ) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("FindOutWord");
		
		EntityManager em=emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(new Result(playerName, theWord, secCounter, clickCounter, date));
		
		em.getTransaction().commit();
		
		em.close();
		
		emf.close();
		
	}
	
	public List<Result> getAllResults(){
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("FindOutWord");
		
		EntityManager em=emf.createEntityManager();
		
		TypedQuery<Result> query =em.createQuery("SELECT r FROM Result r", Result.class);
		
		List<Result> store=query.getResultList();
		
		em.close();
		
		emf.close();
		
		return store;
	}
	
	
	public void deleteAllResults() {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("FindOutWord");
		
		EntityManager em=emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.createNativeQuery("TRUNCATE TABLE Result").executeUpdate();
		
		em.getTransaction().commit();
		
		em.close();
		
		emf.close();
	}
	

	
}
