package com.hb8manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch08 {
    public static void main(String[] args) {
        Configuration con=new Configuration()
                .configure("hibernate.cfg.xml").addAnnotatedClass(Student08.class)
                .addAnnotatedClass(Book03.class);



        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();


        //use get() and fetch student or book obj
        Student08 st1=session.get(Student08.class,1002);
        System.out.println(st1);

        Book03 book1=session.get(Book03.class,103);
        System.out.println(book1);



        tx.commit();//info will be send to DB
        session.close();
        sf.close();
    }
}
