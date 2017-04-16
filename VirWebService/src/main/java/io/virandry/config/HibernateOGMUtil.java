package io.virandry.config;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.ogm.cfg.OgmConfiguration;

public class HibernateOGMUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	final static Logger logger = Logger.getLogger(HibernateOGMUtil.class);

	private HibernateOGMUtil() {
	}

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new OgmConfiguration().configure();

			// assuming you are using JTA in a non contained environment
			configuration.setProperty(AvailableSettings.TRANSACTION_COORDINATOR_STRATEGY, "org.hibernate.transaction.JTATransactionFactory");
			// assuming JBoss TransactionManager in standalone mode
			configuration.setProperty(AvailableSettings.JTA_PLATFORM, "org.hibernate.service.jta.platform.internal.JBossStandAloneJtaPlatform");

			// assuming the default infinispan settings
			configuration.setProperty("hibernate.ogm.datastore.provider", "mongodb");

			return configuration.configure().buildSessionFactory();
		} catch (Exception ex) {
			logger.debug("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}
}