package com.tap;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class Launch {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		Query query = session.createQuery("from Employee e");
		List list=query.getResultList();
		
		
		for(Object o: list) {
			System.out.println(o);
		}
		 Transaction t=session.beginTransaction();
		 t.commit();
	}

}
