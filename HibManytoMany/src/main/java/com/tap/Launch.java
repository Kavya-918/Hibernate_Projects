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
		
	    //uncomment while postiing
	    //show database sql
		//crud 
	    
	    //Employee ready
		/*Employee stev=new Employee(1,"Steev");
		Employee Tim=new Employee(2,"Tim");
		
		Project googleDocx=new Project(1,"google_docx");
		Project googleSlides=new Project(2,"google_slides");
		
		ArrayList<Project> al1 = new ArrayList<Project>();
		al1.add(googleDocx);
		al1.add(googleSlides);
		stev.setProjects(al1);
		Tim.setProjects(al1);
		
		session.save(stev);
		session.save(Tim);
		session.save(googleDocx);
		session.save(googleSlides);*/
	    
	    Employee stev=session.get(Employee.class, 1);
	    //System.out.println(stev.getId()+" "+stev.getEmployeeName());
	    //or
	    //System.out.print(stev);
	    List<Project>projects=stev.getProjects();
	    System.out.println(projects);
	    
	    
		
		
		
		t.commit();
	}

}
