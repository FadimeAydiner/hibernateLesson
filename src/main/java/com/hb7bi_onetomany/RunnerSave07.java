package com.hb7bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave07 {
    public static void main(String[] args) {

        Student07 st1=new Student07();
        st1.setId(1001);
        st1.setName("Fadime");

        Student07  st2=new Student07();
        st2.setId(1002);
        st2.setName("Eyüp");

        Student07 st3=new Student07();
        st3.setId(1003);
        st3.setName("Bilge nur");

        Book02 book1=new Book02();
        book1.setId(101);
        book1.setName("Karamazov Kardeşler");

        Book02 book2=new Book02();
        book2.setId(102);
        book2.setName("Suç ve Ceza");

        Book02 book3=new Book02();
        book3.setId(103);
        book3.setName("Anna Karanina");

        Book02 book4=new Book02();
        book4.setId(104);
        book4.setName("Monte Cristo Kontu");

        Book02 book5=new Book02();
        book5.setId(105);
        book5.setName("Insan ne ile yaşar");








       book1.setStudent(st1);
       book2.setStudent(st1);
       book3.setStudent(st2);
       book4.setStudent(st2);
       book5.setStudent(st3);





        Configuration con=new Configuration()
                .configure("hibernate.cfg.xml").addAnnotatedClass(Student07.class)
                .addAnnotatedClass(Book02.class);



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
