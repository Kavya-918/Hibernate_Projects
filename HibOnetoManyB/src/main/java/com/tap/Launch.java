package com.tap;

import java.util.List;

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
	
	  Customer c=session.get(Customer.class, 1);
	  System.out.println(c);
	  //giving list of orders done by 1
	  List<Orders> li = c.getOrders();
	  
	  //accessing through loop or iterator any
	  
	  for(Object o:li) {
		  System.out.println(o);
	  }
	  /*if you want to delete
	   
	     Customer c=session.get(Customer.class, 1);
	     session.delete(c);
	     Hibernate do with the help of cascading
	   * 
	   * */
	  
	  /* want to delete orders
	   * Orders o1=session.get(Customer.class, 1);
	     session.delete(o1);
	     all orders and customer details all delete
	   * 
	   
	   * now steev and remaining orders not delete only particular order delete veg biryani
	   * goto orderclass
	   * instead cascadeAll give 
	   * cascade={CascadeType.DETACH},{CascadeType.MERGE},{CascadeType.PERSIST},{CascadeType.REFRESH})
	   * 
	   * in launch
	   *  Orders o1=session.get(Customer.class, 1);
	   *  session.delete(o);
	   * */
	  
	
	
	t.commit();
	
	

	}

}


