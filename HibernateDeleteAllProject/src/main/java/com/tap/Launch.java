package com.tap;


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
		//whenever you need to updatation and deletion begin transaction 1st
		Transaction t=session.beginTransaction();
		Query query =session.createQuery("Delete from Employee e where e.department = 'HR'");
		int n = query.executeUpdate();
		System.out.println(n);
		
		 
		 t.commit();
	}

}
