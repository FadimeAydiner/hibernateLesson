package com.uni_manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave05 {
    public static void main(String[] args) {
        Student05 st1=new Student05();
        st1.setId(1001);
        st1.setName("Fadime");
        st1.setGrade(70);

        Student05 st2=new Student05();
        st2.setId(1002);
        st2.setName("Eyüp");
        st2.setGrade(80);

        Student05 st3=new Student05();
        st3.setId(1003);
        st3.setName("Bilge Nur");
        st3.setGrade(100);

        University uni=new University();
        uni.setId(101);
        uni.setName("Marmara");

        st1.setUniversity(uni);
        st2.setUniversity(uni);
        st3.setUniversity(uni);

        Configuration con=new Configuration()
                .configure("hibernate.cfg.xml").addAnnotatedClass(Student05.class)
                .addAnnotatedClass(University.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        session.save(uni);
        session.save(st1);
        session.save(st2);
        session.save(st3);



        tx.commit();//info will be send to DB
        session.close();
        sf.close();

    }
}
