package com.hb12hibernatecaching;

import com.hb11criteriaapi.Student11;
import com.hb9fetchTypes.Student09;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Random;

public class RunnerSave12 {
    public static void main(String[] args) {

        Student12 st1=new Student12();
        st1.setName("Fadime");
        st1.setGrade(90);

        Student12 st2=new Student12();
        st2.setName("Eyüp");
        st2.setGrade(100);

        Student12 st3=new Student12();
        st3.setName("Bilge nur");
        st3.setGrade(80);


        Configuration con=new Configuration()
                .configure("hibernate.cfg.xml").addAnnotatedClass(Student12.class);



        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();


        session.save(st1);
        session.save(st2);
        session.save(st3);


        tx.commit();//info will be send to DB
        session.close();
        sf.close();
    }
}
