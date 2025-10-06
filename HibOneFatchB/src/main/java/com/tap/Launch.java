package com.tap;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Launch {

	public static void main(String[] args) {
	Configuration cfg = new Configuration();
	cfg.configure();
	cfg.addAnnotatedClass(Customer.class);
	cfg.addAnnotatedClass(CustomerDetails.class);
	Session session  = cfg.buildSessionFactory().openSession();
	Transaction t = session.beginTransaction();
	
	 CustomerDetails cd =session.get(CustomerDetails.class, 101);
	 System.out.println(cd);
	 Customer c = cd.getCustomer();
	 System.out.println(c);
	
	t.commit();
	

	}

}
