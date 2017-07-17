package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.hibernate.model.User;
import com.hibernate.util.HibernateUtil;

public class UserMain {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Transaction tran = s.beginTransaction();
		User user = new User();
		user.setUserName("ryz147");
		s.save(user);
		tran.commit();
		//User user= s.load(User.class, 1L);
		//User user =s.get(User.class, 2L); //if the user is not there, this s.get method will throw null pointer exception
		System.out.println(user.getUserName());
		
		//user.setUserName("ryz147@gmail.com");
		//user.setUserName("Riyaz");

		//System.out.println(user.getUserName());
//		s.save(user);
//		tran.commit();
		s.close();
		sf.close();
	}

}
