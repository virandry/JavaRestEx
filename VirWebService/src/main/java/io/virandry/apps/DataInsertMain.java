package io.virandry.apps;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import io.virandry.config.HibernateOGMUtilEMF;
import io.virandry.model.AudienceScore;
import io.virandry.model.Movie;
import io.virandry.model.TomatoMeter;

public class DataInsertMain {

	private static EntityManagerFactory entityManagerFactory;

	public static void main(String[] args) {

		entityManagerFactory = HibernateOGMUtilEMF.getEntityManagerFactory();
		EntityManager em = entityManagerFactory.createEntityManager();
		Movie movie1 = new Movie("KONG: SKULL ISLAND", 2017, "/jerjack/images/kong.jpg",
				new TomatoMeter("6.6/10", "273", "212", "61"), new AudienceScore("3.7/5", "38,245"));
		Movie movie2 = new Movie("Ghost in the Shell", 2017, "/jerjack/images/ghost.jpg",
				new TomatoMeter("5.5/10", "159", "68", "91"), new AudienceScore("3.5/5", "28,203"));
		em.getTransaction().begin();
		em.persist(movie1);
		em.persist(movie2);
		em.getTransaction().commit();
		em.close();

	}
}