package io.virandry.apps;

import org.hibernate.Session;

import io.virandry.config.HibernateOGMUtil;
import io.virandry.model.AudienceScore;
import io.virandry.model.Movie;
import io.virandry.model.TomatoMeter;

public class DataInsertMain {

	private static Session session;

	public static void main(String[] args) {

		session = HibernateOGMUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Movie movie1 = new Movie("KONG: SKULL ISLAND", 2017, "/jerjack/images/kong.jpg",
					new TomatoMeter("6.6/10", "273", "212", "61"), new AudienceScore("3.7/5", "38,245"));
			Movie movie2 = new Movie("Ghost in the Shell", 2017, "/jerjack/images/ghost.jpg",
					new TomatoMeter("5.5/10", "159", "68", "91"), new AudienceScore("3.5/5", "28,203"));
			session.save(movie1);
			session.save(movie2);
			session.flush();
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
	}
}