package com.hb12hibernatecaching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch12 {
    public static void main(String[] args) {
        Configuration con=new Configuration()
                .configure("hibernate.cfg.xml").addAnnotatedClass(Student12.class);



        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

//1.level cacheing is enabled by default and it works in the same session
        //let's check first level caching
        System.out.println("first get() for student whose id is 1");
        Student12 s1=session.get(Student12.class,1L);

        //session.clear();//clears the cache memory
        System.out.println("second get() for student whose id is 1");
        Student12 s2=session.get(Student12.class,1L);


        tx.commit();//info will be send to DB
        session.close();

        Session session2=sf.openSession();
        Transaction tx2=session2.beginTransaction();
        System.out.println("third get() for student whose id is 1");
        Student12 s3=session2.get(Student12.class,1L);


        tx2.commit();
        session2.close();
        sf.close();
    }
}
