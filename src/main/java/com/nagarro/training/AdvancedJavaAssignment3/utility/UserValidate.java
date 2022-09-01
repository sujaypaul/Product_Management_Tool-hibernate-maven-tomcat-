package com.nagarro.training.AdvancedJavaAssignment3.utility;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nagarro.training.AdvancedJavaAssignment3.models.Users;

public class UserValidate {

	public static Users validate(String username) {

		Session session = HibernateUtil.usersSF().openSession();
		session.beginTransaction();
		Query<Users> query = session.createQuery("from Users where uname=:uname", Users.class);
		query.setParameter("uname", username);

		Users user=null;
		try {
			user = query.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("no user found with this username");
		}
		session.getTransaction().commit();
		session.close();

		if (user != null) {
			return user;
		} else {
			return null;
		}

	}
}
