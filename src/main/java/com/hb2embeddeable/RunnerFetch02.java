package com.hb2embeddeable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch02 {
    public static void main(String[] args) {
        //Configuration
        Configuration con=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student02.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        Student02 std1=session.get(Student02.class,1001);
        System.out.println(std1);
        System.out.println(std1.getAddress());




        tx.commit();//info will be send to DB
        session.close();
        sf.close();
    }
}
