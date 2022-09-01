package com.nagarro.training.AdvancedJavaAssignment3.utility;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nagarro.training.AdvancedJavaAssignment3.models.Products;

public class ProductDao {

	public static void saveProduct(Products product) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.productsSF().openSession()) {
			transaction = session.beginTransaction();
			session.save(product);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}
