package com.bi_onetoone;

import com.uni_onetoone.Diary;
import com.uni_onetoone.Student03;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {
    public static void main(String[] args) {
        Configuration con=new Configuration()
                .configure("hibernate.cfg.xml").addAnnotatedClass(Student04.class)
                .addAnnotatedClass(Diary02.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();


        System.out.println( session.get(Student04.class,1001));
        System.out.println( session.get(Diary02.class,101));

        System.out.println("*****using get() fetch student from diary");
        Diary02 diary=session.get(Diary02.class,101);
        System.out.println(diary.getStudent());

        Student04 st=session.get(Student04.class,1001);
        System.out.println(st.getDiary());


        System.out.println("*********************Using HQL with INNER JOIN*************************");
        String query="SELECT s.name,d.name FROM Student04 s INNER JOIN FETCH Diary02 d ON s.id=d.student";
        List<Object[]> resultList1=session.createQuery(query).getResultList();

        for(Object[] obj:resultList1) {

            System.out.println(Arrays.toString(obj));
        }

        //resultList1.forEach(objects -> System.out.println(Arrays.toString(objects)));

        //Using Left join

        //Fetch all students and students with dairy
        System.out.println("*********************Using HQL with LEFT JOIN*************************");
        String hqQuery="SELECT s.name,d.name FROM Student04 s LEFT JOIN FETCH Diary02 d ON s.id=d.student";
        List<Object[]> resultList2=session.createQuery(hqQuery).getResultList();

        for(Object[] obj:resultList2) {

            System.out.println(Arrays.toString(obj));
        }

        //Using Right join

        //Fetch all diaries and diaries with student
        System.out.println("*********************Using HQL with RIGHT JOIN*************************");
        String hqLQuery="SELECT s.name,d.name FROM Student04 s RIGHT JOIN FETCH Diary02 d ON s.id=d.student";
        List<Object[]> resultList3=session.createQuery(hqLQuery).getResultList();

        for(Object[] obj:resultList3) {

            System.out.println(Arrays.toString(obj));
        }
        //Using Full  join

        //Fetch all diaries and diary owners
        System.out.println("*********************Using HQL with FULL JOIN*************************");
        String hqlQuery="SELECT s.name,d.name FROM Student04 s FULL JOIN FETCH Diary02 d ON s.id=d.student";
        List<Object[]> resultList4=session.createQuery(hqlQuery).getResultList();

        for(Object[] obj:resultList4) {

            System.out.println(Arrays.toString(obj));
        }
        tx.commit();
        session.close();;
        sf.close();
    }
}
