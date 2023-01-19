package com.hb11criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Random;

public class RunnerFetch11 {
    public static void main(String[] args) {
        Configuration con=new Configuration()
                .configure("hibernate.cfg.xml").addAnnotatedClass(Student11.class);



        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();


      /*CRUD (Create Read Update Delete)
        Create-->session.save();
        Read  -->session.get();
        Update-->session.update(),updateQuery();
        Delete-->session.delete();

        */

        /*
        //1.way update using update()
        Student11 student1=session.get(Student11.class,15);
        System.out.println("Student before update: "+student1);

        student1.setName("Fadime");
        student1.setGrade(100);

        session.update(student1);
        System.out.println("Student after update: "+student1);
*/
/*
        //2.way update using query
        //set grades that are less than 75 to 80

        int sGrade=80;
        int lGrade=75;

        String hqlQuery="UPDATE Student11 s SET s.grade=:sMath WHERE s.grade<:lMath";

        Query query=session.createQuery(hqlQuery);
        query.setParameter("sMath",sGrade);
        query.setParameter("lMath",lGrade);
        int numberOfUpdatedRows=query.executeUpdate();
        System.out.println(numberOfUpdatedRows);
*/

        //Criteria API

        CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
        CriteriaQuery<Student11> criteriaQuery=criteriaBuilder.createQuery(Student11.class);
        Root<Student11> root=criteriaQuery.from(Student11.class);

        /*
        //Example 1 : Fetch all Students
        criteriaQuery.select(root);//Select * from Student11
        Query<Student11> query1=session.createQuery(criteriaQuery);
        List<Student11> resultList=query1.getResultList();
        resultList.forEach(std-> System.out.println(std));
*/
        /*
        //Example 2: Get student whose name is Fadime
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("name"),"Fadime"));
        Query<Student11> query1=session.createQuery(criteriaQuery);
        List<Student11> resultList=query1.getResultList();
        resultList.forEach(std-> System.out.println(std));
*/
        /*
        //Example 3: Fetch students whose grade is grater than 80
        criteriaQuery.select(root).where(criteriaBuilder.greaterThan(root.get("grade"),80));
        Query<Student11> query1=session.createQuery(criteriaQuery);
        List<Student11> resultList=query1.getResultList();
        resultList.forEach(std-> System.out.println(std));
*/
        //Example 4: Fetch students whose grade is less tahn 95
        criteriaQuery.select(root).where(criteriaBuilder.lessThan(root.get("grade"),95));
        Query<Student11> query1=session.createQuery(criteriaQuery);
        List<Student11> resultList=query1.getResultList();
        resultList.forEach(std-> System.out.println(std));
        tx.commit();//info will be send to DB
        session.close();
        sf.close();
    }
}
