package com.hb7bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch07 {
    public static void main(String[] args) {
        Configuration con=new Configuration()
                .configure("hibernate.cfg.xml").addAnnotatedClass(Student07.class)
                .addAnnotatedClass(Book02.class);



        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();
/*
       Student07 st1= session.get(Student07.class,1001);
       System.out.println(st1.getBookList());



       st1.getBookList().forEach(std-> System.out.println(std));

       st1.getBookList().forEach(System.out::println);

       //fetch books of student whose id is 1001 using hql


        Book02 book1=session.get(Book02.class,101);
        System.out.println(book1.getStudent());

*/
     /*   //using sql,fetch name of book and students from Student07who has book
        String hqlQuery = "Select s.name, b.name from Student07 s inner join Book02 b on s.id = b.student.id";
        List<Object[]> res = session.createQuery(hqlQuery).getResultList();
        for (Object[] o: res){
            System.out.println("Arrays.toString(o) = " + Arrays.toString(o));
        }*/

       /* //DELETE records of Book02 using SQL
        String sqlQuery="DELETE FROM t_book02";
        int numberOfDetetedRecords=session.createSQLQuery(sqlQuery).executeUpdate();
        System.out.println(numberOfDetetedRecords);
*/


        /*
        //DELETE records of Student07 using SQL

        String sqlQuery2="DELETE FROM t_student07";
        int numberOfDetetedRecords2=session.createSQLQuery(sqlQuery2).executeUpdate();
        System.out.println(numberOfDetetedRecords2);
*/


        //DELETE records of Book02 using HQL
/*
        String hqlQuery="DELETE FROM Book02";
        int numberOfDetetedRecords=session.createQuery(hqlQuery).executeUpdate();
        System.out.println(numberOfDetetedRecords);
*/
        //DELETE records of Student07 using HQL
/*
       String hqlQuery="DELETE FROM Student07";
        int numberOfDetetedRecords=session.createQuery(hqlQuery).executeUpdate();
        System.out.println(numberOfDetetedRecords);
*/


        //Delete Book record which is name as "Karamazov Kardeşler"

       String hqlQuery="DELETE FROM Book02 b WHERE b.name='Anna Karanina'";
        int numberOfDetetedRecords=session.createQuery(hqlQuery).executeUpdate();
        System.out.println(numberOfDetetedRecords);






        //orphanRemoval
        //Delete Student07 object whose id is 1001
        /*Student07 student=session.get(Student07.class,1001);
        session.delete(student);*/


        //Text:Write hql query which will bring books whose name has word "Anna"
      /*  String hqlQuery="Select b.name,s.name from Student07 s JOIN s.bookList b where b.name like '%Anna%'";

        List<Object[]> res=session.createQuery(hqlQuery).getResultList();
        res.forEach(book02 -> System.out.println(Arrays.toString(book02)));
*/


        tx.commit();//info will be send to DB
        session.close();
        sf.close();
    }
}
