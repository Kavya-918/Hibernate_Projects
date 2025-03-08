package com.tap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Launch {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);
		//with the help of session object only we can insert objects as value
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session=sessionFactory.openSession();
		//fetch data
		Employee e=session.get(Employee.class, 2);
		System.out.println(e);
		
		//need to use tostring otherwise we get address
		
		
		 Transaction t=session.beginTransaction();
		 t.commit();
	}

}
