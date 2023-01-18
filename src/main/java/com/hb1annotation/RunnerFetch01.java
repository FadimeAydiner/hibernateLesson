package com.hb1annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {
    public static void main(String[] args) {
        Configuration con=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student01.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        //There are 3 ways of fetching data from DB
            //1.get()
            //2.SQL
            //3.HQL

        //*************************1.way:get()****************************

       /*Student01 student01= session.get(Student01.class,101);
       Student01 student02= session.get(Student01.class,102);
       Student01 student03= session.get(Student01.class,103);

        System.out.println(student01);
        System.out.println(student02);
        System.out.println(student03);
 */
        //*************************2.way:SQL****************************
    /*String sqlQuery="Select * from t_student01";
    List<Object[]> resultList=session.createSQLQuery(sqlQuery).getResultList();
    for(Object[] o:resultList)
    System.out.println(Arrays.toString(o));
*/

//*************************3.way:HQL****************************
    /*String hqlQuery="From Student01";

    List<Student01> resultListHql=session.createQuery(hqlQuery, Student01.class).getResultList();

    for(Student01 s:resultListHql)
    System.out.println(s.toString());
*/



      //******Fetcing unique data using SQL******

        String sqlQuery2="select * from t_student01 where std_name='Bilge Nur Aydiner'";
        Object[] student3=(Object[])session.createSQLQuery(sqlQuery2).uniqueResult();
        System.out.println(Arrays.toString(student3));

        //******Fetcing unique data using HQL******

        String hqlQuery2="from Student01 where name='Eyüp Aydiner'";
        Student01 student2=session.createQuery(hqlQuery2, Student01.class).uniqueResult();
        System.out.println(student2);

        //******Fetcing  data using alias HQL******
        String hqlQuery3="Select s.name,s.grade From Student01 s where s.id<103";
        List<Object[]> resultListhql=session.createQuery(hqlQuery3).getResultList();
        for(Object[] objects:resultListhql)
        System.out.println(Arrays.toString(objects));




        tx.commit();//info will be send to DB
        session.close();
        sf.close();

    }
}

