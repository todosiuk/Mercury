package org.myapp.mercury.app.persistence.hibernate;

import javax.annotation.PreDestroy;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.myapp.mercury.app.model.entity.logistic.Supplier;
import org.myapp.mercury.app.model.entity.logistic.Supply;
import org.myapp.mercury.app.model.entity.person.Account;

/**
 * Component that is responsible for managing Hibernate session factory
 * 
 * @author todosuk
 *
 */
public class SessionFactoryBuilder {

	private final SessionFactory sessionFactory;

	public SessionFactoryBuilder() {
		ServiceRegistry registry = new StandardServiceRegistryBuilder().build();

		MetadataSources sources = new MetadataSources(registry);

		sources.addAnnotatedClass(Supplier.class);
		sources.addAnnotatedClass(Supply.class);
		sources.addAnnotatedClass(Account.class);

		sessionFactory = sources.buildMetadata().buildSessionFactory();
	}

	/**
	 * Returns single instance of session factory
	 * 
	 * @return
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@PreDestroy
	public void destroy() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
}
