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
		
		//Employee e = new Employee(1,"Tim",20000,"tim@gmail.com","IT");
		//Employee e1 = new Employee(2,"Steeve",30000,"stev@gmail.com","IT");
		//Employee e2 = new Employee(3,"Elonmusk",22000,"elon@gmail.com","HR");
		//Employee e3 = new Employee(4,"Satyanadella",20000,"satya@gmail.com","HR");
		Employee e1 = new Employee(5,"ratna tata",89000,"tata@gmail.com","IT");
		Employee e2 = new Employee(6,"AravindhKrishna",9000,"ak@gmail.com","HR");
		Employee e3 = new Employee(7,"Bill Gates ",34600,"bg@gmail.com","IT");
		//session.save(e);
		session.save(e1);
		session.save(e2);
		session.save(e3);
		//to save 
		//Transaction choose org hibernate while importing
		 Transaction t=session.beginTransaction();
		 t.commit();
		 
	}

}
