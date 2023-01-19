package com.hb10idgeneration;

import com.hb9fetchTypes.Book04;
import com.hb9fetchTypes.Student09;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave10 {
    public static void main(String[] args) {
        Student10 student=new Student10();
        student.setName("Fadime");

        Student10 student2=new Student10();
        student2.setName("Bilge Nur");

        Configuration con=new Configuration()
                .configure("hibernate.cfg.xml").addAnnotatedClass(Student10.class);



        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();



        session.save(student);
        session.save(student2);

        tx.commit();//info will be send to DB
        session.close();
        sf.close();
    }
}
