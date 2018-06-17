package com.july.backend.util;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory factory;
	private static StandardServiceRegistry registry;
	
	public static SessionFactory getSessionFatory() {
		if (factory == null) {
			registry = new StandardServiceRegistryBuilder()
					.configure("hibernate.cfg.xml")
					.build();
			MetadataSources metadataSource = new MetadataSources(registry);
			Metadata metadata = metadataSource.getMetadataBuilder().build();
			factory = metadata.getSessionFactoryBuilder().build();
		}
		return factory;
	}
	
	public static void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
}
