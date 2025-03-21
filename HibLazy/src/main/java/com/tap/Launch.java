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
		
	    Employee e=session.get(Employee.class, 1);
	    System.out.println(e);
	    //lazy loading
	    //after specifically tell only it load
	    System.out.println(e.getProjects());
		
		t.commit();
	}

}
