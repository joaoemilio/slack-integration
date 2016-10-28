package com.ibm.watsonibmer.dao;

import javax.persistence.EntityManager;

public class ConfigDAO extends AbstractDAO {

	public ConfigDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	/*
	public ConfigDAO(EntityManager em) {
		super(em);
	}
	
	public Config find(UUID uuid) {
		return em.find(Config.class, uuid);
	}
	
	public void save(Config domain) {
		em.persist(domain);
	}
	*/

}
