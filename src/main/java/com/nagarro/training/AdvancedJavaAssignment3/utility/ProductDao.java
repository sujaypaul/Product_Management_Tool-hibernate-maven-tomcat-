package com.nagarro.training.AdvancedJavaAssignment3.utility;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nagarro.training.AdvancedJavaAssignment3.models.Constants;
import com.nagarro.training.AdvancedJavaAssignment3.models.Products;

public class ProductDao {

	public static void saveProduct(Products product,float size) {
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
	
	public static List<Products> productList(String username){
		Session session = HibernateUtil.productsSF().openSession();
		String query = "from Products where user='"+username+"'";

		Query<Products> q = session.createQuery(query);
		

		List<Products> productlist = q.list();
		
		Constants.dbImageLimit = 0;
		
		for(Products p : productlist) {
			
			Constants.dbImageLimit += (p.getImage().length / Constants.byteunit);
			System.out.println(p.getImage().length);
			System.out.println(Constants.dbImageLimit);

		}
		return productlist;
	}
	
	public static void deleteProduct(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.productsSF().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            Products product= session.get(Products.class, id);
            if (product != null) {
                session.delete(product);
                
//    			Constants.dbImageLimit -= (product.getImage().length / Constants.byteunit);

                System.out.println("user is deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
	
	public static Products getProduct(int id) {

        Transaction transaction = null;
        Products product = null;
        try (Session session = HibernateUtil.productsSF().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            product = session.get(Products.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return product;
    }
	
	public static void updateProduct(Products product,float size) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.productsSF().openSession()) {
        	

            transaction = session.beginTransaction();
            session.update(product);
            transaction.commit();
            
            
//			Constants.dbImageLimit += (size / Constants.byteunit);

            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

}
