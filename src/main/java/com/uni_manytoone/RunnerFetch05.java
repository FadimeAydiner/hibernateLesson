package com.uni_manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RunnerFetch05 {
    public static void main(String[] args) {
        Configuration con=new Configuration()
                .configure("hibernate.cfg.xml").addAnnotatedClass(Student05.class)
                .addAnnotatedClass(University.class);
        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();


        System.out.println(session.get(Student05.class,1002).getUniversity());


        //fetch students whose uni id is 101 using hql

        /*Bunu ben yaptım sadece öğrenci isimlerini alsım String list e "
        String hqlQuery="SELECT s.name FROM Student05 s WHERE s.university.id=101";
        List<String> resultList=session.createQuery(hqlQuery).getResultList();
        for (String o:resultList)
            System.out.println(o);*/

        String hqlQuery="FROM Student05 s WHERE s.university.id=101";
        List<Student05> resultList=session.createQuery(hqlQuery,Student05.class).getResultList();
        resultList.forEach(st-> System.out.println(st.toString()));


        tx.commit();//info will be send to DB
        session.close();
        sf.close();
    }
}
