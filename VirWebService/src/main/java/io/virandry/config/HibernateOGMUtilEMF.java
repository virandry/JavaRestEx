package io.virandry.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

public class HibernateOGMUtilEMF {
	private static EntityManagerFactory entityManagerFactory = null;
	final static Logger logger = Logger.getLogger(HibernateOGMUtilEMF.class);
	
	static {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("mongodb-en");
		} catch (Exception e) {
			logger.debug("Initial EntityManagerFactory creation failed." + e);
		}
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public static void closeEntityManagerFactory() {
		entityManagerFactory.close();
	}
}
