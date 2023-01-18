package com.hb6uni_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch06 {
    public static void main(String[] args) {
        Configuration con=new Configuration()
                .configure("hibernate.cfg.xml").addAnnotatedClass(Student06.class)
                .addAnnotatedClass(Book.class);



        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

       Student06 st1= session.get(Student06.class,1002);
       System.out.println(st1.toString());
       System.out.println(st1.getBookList().toString());

       //fetch books of student whose id is 1001 using hql

        String query="SELECT b.id,b.name FROM Student06 s INNER JOIN s.bookList b WHERE s.id=1002";
        List<Object[]> resultList=session.createQuery(query).getResultList();
        resultList.forEach(obj-> System.out.println(Arrays.toString(obj)));

        tx.commit();//info will be send to DB
        session.close();
        sf.close();
    }
}
