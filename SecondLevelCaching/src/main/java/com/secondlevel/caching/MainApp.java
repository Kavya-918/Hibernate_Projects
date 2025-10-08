package com.secondlevel.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        // 1st Session
        Session session1 = factory.openSession();
        System.out.println("------- First Session -------");
        Student s1 = session1.get(Student.class, 1); // DB hit
        System.out.println(s1);
        session1.close();

        // 2nd Session
        Session session2 = factory.openSession();
        System.out.println("------- Second Session -------");
        Student s2 = session2.get(Student.class, 1); // Cache hit
        System.out.println(s2);
        session2.close();

        factory.close();
        //output: First session hits DB, second session reads from Ehcache.
        /*
         * ------- First Session -------
Hibernate: select student0_.id as id1_0_0_, student0_.city as city2_0_0_, student0_.name as name3_0_0_ from Student student0_ where student0_.id=?
Student [id=1, name=Kavya, city=Hyderabad]
------- Second Session -------
Student [id=1, name=Kavya, city=Hyderabad]
         */
    }
}