package io.virandry.apps;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import io.virandry.config.HibernateOGMUtil;
import io.virandry.model.AudienceScore;
import io.virandry.model.Movie;
import io.virandry.model.TomatoMeter;


public class DataInsertMain {

	private static EntityManagerFactory entityManagerFactory;

	public static void main(String[] args) {

		/* Line 1 */ entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		/* Line 2 */ EntityManager em = entityManagerFactory.createEntityManager();
		Movie movie1 = new Movie(1, "KONG: SKULL ISLAND", 2017, "/jerjack/images/kong.jpg",
				new TomatoMeter("6.6/10", "273", "212", "61"), new AudienceScore("3.7/5", "38,245"));
		
		/* Line 5 */ em.getTransaction().begin();
		/* Line 6 */ em.persist(movie1);
		/* Line 7 */ em.getTransaction().commit();
		/* Line 8 */ em.close();
		/* Line 9 */ HibernateOGMUtil.closeEntityManagerFactory();
	}
}