package com.uni_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {
    public static void main(String[] args) {
        Configuration con=new Configuration()
                .configure("hibernate.cfg.xml").addAnnotatedClass(Student03.class)
                .addAnnotatedClass(Diary.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();


        System.out.println( session.get(Student03.class,1001));
        System.out.println( session.get(Diary.class,1));

        System.out.println("*****using get() fetch student from diary");
        Diary diary=session.get(Diary.class,1);
        System.out.println(diary.getStudent());



        tx.commit();
        session.close();;
        sf.close();
    }

}
