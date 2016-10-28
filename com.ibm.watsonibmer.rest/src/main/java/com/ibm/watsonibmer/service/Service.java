package com.ibm.watsonibmer.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ibm.watsonibmer.domain.TransferObject;

public class Service {
	protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("watson-ibmer"); 
	protected EntityManager em;
		
	protected void startTransaction() {
		this.em = emf.createEntityManager();
		em.getTransaction().begin();
	}
	
	public void commitTransaction() {
		try{
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		try{
			em.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public void save(TransferObject object) {
		startTransaction();
		em.merge(object);
		commitTransaction();
	}
}
