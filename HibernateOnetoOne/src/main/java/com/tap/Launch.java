package com.tap;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Launch {

	public static void main(String[] args) {
	Configuration cfg = new Configuration();
	cfg.configure();
	//if you have 2 annotated Classess you need to call 2 type in one we cant put 2 
	//how many class that many annotated class should call
	cfg.addAnnotatedClass(Customer.class);
	cfg.addAnnotatedClass(CustomerDetails.class);
	Session session  = cfg.buildSessionFactory().openSession();
	Transaction t = session.beginTransaction();
	
	Customer c=new Customer(5,"Satya Nadella");
	CustomerDetails cd=new CustomerDetails(105,"Satya Nadella@gmail.com",98907421,"India");
	c.setCustomerDetails(cd);//mapping to table2
	session.save(c);
	t.commit();
	

	}

}
