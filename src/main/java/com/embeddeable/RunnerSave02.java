package com.embeddeable;

import com.annotation.Student01;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {
    public static void main(String[] args) {
        Student02 student02=new Student02();

        student02.setName("Muhammed Akdeniz");
        student02.setId(1001);
        student02.setGrade(100);

        Address address1=new Address();
        address1.setStreet("Kazım Karabekir");
        address1.setCity("Manisa");
        address1.setCountry("Turkey");
        address1.setZipCode("1234");
        student02.setAddress(address1);

        Student02 student03=new Student02();

        student03.setName("Hacer Akdeniz");
        student03.setId(1002);
        student03.setGrade(90);

        Address address2=new Address();
        address2.setStreet("AliBey Köy");
        address2.setCity("Manisa");
        address2.setCountry("Turkey");
        address2.setZipCode("1237");
        student03.setAddress(address2);

        //Configuration
        Configuration con=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student02.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        session.save(student02);
        session.save(student03);




        tx.commit();//info will be send to DB
        session.close();
        sf.close();
    }
}
