package com.uni_onetoone;

import com.annotation.Student01;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {
    public static void main(String[] args) {
        Student03 student03=new Student03();
        student03.setId(1001);
        student03.setName("Banu");
        student03.setGrade(90);

        Diary diary=new Diary();
        diary.setId(1);
        diary.setName("Diary1");
        diary.setStudent(student03);

        Student03 student04=new Student03();
        student04.setId(1002);
        student04.setName("Zehra");
        student04.setGrade(90);

        Diary diary2=new Diary();
        diary2.setId(2);
        diary2.setName("Diary2");
        diary2.setStudent(student04);

        Configuration con=new Configuration()
                .configure("hibernate.cfg.xml").addAnnotatedClass(Student03.class)
                .addAnnotatedClass(Diary.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();


      session.save(student03);
      session.save(student04);
        session.save(diary2);
        session.save(diary);


        tx.commit();//info will be send to DB
        session.close();
        sf.close();
    }
}
