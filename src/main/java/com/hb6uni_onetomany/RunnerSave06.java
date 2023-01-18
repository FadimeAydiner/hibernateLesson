package com.hb6uni_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave06 {
    public static void main(String[] args) {


        Book book1=new Book();
        book1.setId(101);
        book1.setName("Karamazov Kardeşler");

        Book book2=new Book();
        book2.setId(102);
        book2.setName("Suç ve Ceza");

        Book book3=new Book();
        book3.setId(103);
        book3.setName("Anna Karanina");



        Student06 st1=new Student06();
        st1.setId(1001);
        st1.setName("Fadime");

        Student06 st2=new Student06();
        st2.setId(1002);
        st2.setName("Eyüp");

        Student06 st3=new Student06();
        st3.setId(1003);
        st3.setName("Bilge nur");

        st1.getBookList().add(book1);
        st1.getBookList().add(book2);
        st2.getBookList().add(book2);
        st2.getBookList().add(book3);
        st3.getBookList().add(book3);


        Configuration con=new Configuration()
                .configure("hibernate.cfg.xml").addAnnotatedClass(Student06.class)
                .addAnnotatedClass(Book.class);



        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(st1);
        session.save(st3);
        session.save(st2);




        tx.commit();//info will be send to DB
        session.close();
        sf.close();
    }
}
