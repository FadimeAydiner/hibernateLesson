package com.hb9fetchTypes;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave09 {
    public static void main(String[] args) {
        
    
    Student09 st1=new Student09();
        st1.setId(1001);
        st1.setName("Fadime");

    Student09  st2=new Student09();
        st2.setId(1002);
        st2.setName("Eyüp");

    Student09 st3=new Student09();
        st3.setId(1003);
        st3.setName("Bilge nur");

    Book04 book1=new Book04();
        book1.setId(101);
        book1.setName("Karamazov Kardeşler");

    Book04 book2=new Book04();
        book2.setId(102);
        book2.setName("Suç ve Ceza");

    Book04 book3=new Book04();
        book3.setId(103);
        book3.setName("Anna Karanina");

    Book04 book4=new Book04();
        book4.setId(104);
        book4.setName("Monte Cristo Kontu");

    Book04 book5=new Book04();
        book5.setId(105);
        book5.setName("Insan ne ile yaşar");

//normally (if  we are not using cascade) we have to do the setting from relation owner side.
        //since we have cascade type all to set One to Many Relationship we have to do setting from both side

//set books to student
    st1.getBookList().add(book1);
    st1.getBookList().add(book2);
    st2.getBookList().add(book3);
    st1.getBookList().add(book4);
    st3.getBookList().add(book5);

//set student to book
        //if you dont setting from both side related column will be null

    book1.setStudent(st1);
    book2.setStudent(st1);
    book3.setStudent(st2);
    book4.setStudent(st2);
    book5.setStudent(st3);




    Configuration con=new Configuration()
            .configure("hibernate.cfg.xml").addAnnotatedClass(Student09.class)
            .addAnnotatedClass(Book04.class);



    SessionFactory sf=con.buildSessionFactory();
    Session session=sf.openSession();
    Transaction tx=session.beginTransaction();

        session.save(st1);
        session.save(st3);
        session.save(st2);


      /*  session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);

*/



        tx.commit();//info will be send to DB
        session.close();
        sf.close();
}}
