package com.hb8manytomany;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class RunnerSave08 {
    public static void main(String[] args) {
        Student08 st1=new Student08();
        st1.setId(1001);
        st1.setName("Fadime");

        Student08  st2=new Student08();
        st2.setId(1002);
        st2.setName("Eyüp");

        Student08 st3=new Student08();
        st3.setId(1003);
        st3.setName("Bilge nur");

        Book03 book1=new Book03();
        book1.setId(101);
        book1.setName("Karamazov Kardeşler");

        Book03 book2=new Book03();
        book2.setId(102);
        book2.setName("Suç ve Ceza");

        Book03 book3=new Book03();
        book3.setId(103);
        book3.setName("Anna Karanina");

        Book03 book4=new Book03();
        book4.setId(104);
        book4.setName("Monte Cristo Kontu");

        Book03 book5=new Book03();
        book5.setId(105);
        book5.setName("Insan ne ile yaşar");


        List<Book03> bookList1=new ArrayList<>();
        bookList1.add(book1);
        bookList1.add(book2);

        st1.setBookList(bookList1);

        List<Book03> bookList2=new ArrayList<>();
        bookList2.add(book2);
        bookList2.add(book3);

        st2.setBookList(bookList2);

        List<Book03> bookList3=new ArrayList<>();
        bookList3.add(book1);
        bookList3.add(book3);
        bookList3.add(book5);

        st3.setBookList(bookList3);



        Configuration con=new Configuration()
                .configure("hibernate.cfg.xml").addAnnotatedClass(Student08.class)
                .addAnnotatedClass(Book03.class);



        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        session.save(st1);
        session.save(st3);
        session.save(st2);
        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);





        tx.commit();//info will be send to DB
        session.close();
        sf.close();
    }
}
