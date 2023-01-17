package com.bi_onetoone;

import com.uni_onetoone.Diary;
import com.uni_onetoone.Student03;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave04 {
    public static void main(String[] args) {
        Student04 st1=new Student04();
        st1.setId(1001);
        st1.setName("Bilge Nur");
        st1.setGrade(100);

        Student04 st2=new Student04();
        st2.setId(1002);
        st2.setName("Kasım Eren");
        st2.setGrade(95);

        Student04 st3=new Student04();
        st3.setId(1003);
        st3.setName("Faruk");
        st3.setGrade(90);

        Diary02 d1=new Diary02();
        d1.setId(101);
        d1.setName("Bilge Nur's Diary");
        d1.setStudent(st1);

        Diary02 d2=new Diary02();
        d2.setId(102);
        d2.setName("Kasım Eren's Diary");
        d2.setStudent(st2);

        Diary02 d3=new Diary02();
        d3.setId(103);
        d3.setName("Faruk's Diary");
        //d3.setStudent(st3);

//configuration

        Configuration con=new Configuration()
                .configure("hibernate.cfg.xml").addAnnotatedClass(Student04.class)
                .addAnnotatedClass(Diary02.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        session.save(st1);
        session.save(st2);
        session.save(st3);


        session.save(d1);
        session.save(d2);
        session.save(d3);





        tx.commit();
        session.close();;
        sf.close();

    }
}
