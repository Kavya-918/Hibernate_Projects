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
	cfg.addAnnotatedClass(Orders.class);
	Session session  = cfg.buildSessionFactory().openSession();
	Transaction t = session.beginTransaction();
	
	 //session give object order and all details display
	Orders o1 = session.get(Orders.class, 501);
	System.out.println(o1);
	
	//to get Customer in separate
	Customer c=o1.getCustomer();
	System.out.println(c);
	
	//to get CustomerDetails in separate
	CustomerDetails cd = c.getCustomerDetails();
	System.out.println(cd);
	
	t.commit();
	
	

	}

}


