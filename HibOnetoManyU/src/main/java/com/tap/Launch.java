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
	
	 /*Crud operation
	 Orders o1=new Orders(501,"noodles",100);
	 Orders o2=new Orders(502,"fried_rice",150);
	 Orders o3=new Orders(503,"momos",80);
	 Orders o1 = new Orders(504,"veg_biryani",200);
	 Orders o2 = new Orders(505,"chicken_biryani",350);
	 Orders o2 = new Orders(507,"Panipuri",300);*/
	
	Orders o2 = new Orders(508,"chickenroll", 455);
	
	 Customer c = session.get(Customer.class, 2);
	 //o1.setCustomer(c);
	 o2.setCustomer(c);
	  
	// session.save(o1);
	 session.save(o2);
	 
	
	//show output in database
	t.commit();
	
	

	}

}


//create new customer and put
/*
 *  Customer steev = new Customer(5,"steev");
 *  CustomerDetails cd = new CustomerDetails(105,"stev@gmail.com",986543,"patna");
 *  steev.setCustomerDetails(cd);
 *  
 *  Orders o1 = new Orders(507,"veg",120);
 *  Orders o2 = new Orders(508,"veg_biryani",100);
 *  
 *  session.save(o1);
	 session.save(o2);
 * 
 *  t.commit();
 * 
 */
