package com.tap;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Launch {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);
		cfg.addAnnotatedClass(Project.class);
		Session session=cfg.buildSessionFactory().openSession();
	    Transaction t=session.beginTransaction();
		
	    Employee e=session.get(Employee.class, 2);
	    //eager loading give fetch in emp table
	    System.out.println(e);
		
		t.commit();
	}

}
