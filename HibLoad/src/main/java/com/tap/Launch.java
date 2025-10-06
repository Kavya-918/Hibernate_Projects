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
		
	    //CRUD
	    
	   //Employee e=session.load(Employee.class, 1);
	   //System.out.println(e);
	    
	  //Employee e=session.get(Employee.class, 1);
	  //System.out.println(e);
	   //if we show difference call unknown column
	    
	    //Employee e=session.load(Employee.class, 5);
		//System.out.println(e); -- throw error
		
		Employee e1=session.get(Employee.class, 5);
		System.out.println(e1); //null get
		
		
		t.commit();
	}

}
