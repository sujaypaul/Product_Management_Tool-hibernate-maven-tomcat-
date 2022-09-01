package com.nagarro.training.AdvancedJavaAssignment3.utility;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.boot.Metadata;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.nagarro.training.AdvancedJavaAssignment3.models.Products;
import com.nagarro.training.AdvancedJavaAssignment3.models.Users;

public class HibernateUtil {

	public static SessionFactory usersSF() {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Users.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sf = configuration.buildSessionFactory(builder.build());
		return sf;
	}

	public static SessionFactory productsSF() {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Products.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sf = configuration.buildSessionFactory(builder.build());
		return sf;
	}
}
