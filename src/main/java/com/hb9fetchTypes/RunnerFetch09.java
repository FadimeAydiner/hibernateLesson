package com.hb9fetchTypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch09 {
    public static void main(String[] args) {
        Configuration con=new Configuration()
                .configure("hibernate.cfg.xml").addAnnotatedClass(Student09.class)
                .addAnnotatedClass(Book04.class);



        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();


       //get and delete
        /*
        //before FetchType.EAGER //Default FetchType.LAZY
        Student09 st1=session.get(Student09.class,1002);//bu satırı tek çalıştırdığımızda hibernate bize sadece Student sınıfının id ve name ni döndürdü. Gerekli olmadığı için Book taki kitapları döndürmedi
        System.out.println(st1.getName()); bunun için sadece student sınıfın çalışma sı yeterli gerekli olmadığı için Book04 çalışmaz
        System.out.println(st1);//bu satırı çalıştırınca st1 ile ilgili her şeyi istediğimiz için hiberante Student09 u çalıştırp sonra id e göre Book04 teki kitapları da getirdi.
        session.delete(st1);//bu satırda cascade.all yaptığımız için Student09 üstünden Book04 teki bilgileri de alıp öğrenciyle birlikte kitaplarını da sildi.
        //yani FetchType.LAZY gerekli olduğu durumlarda child sınıfı çağırdı. gerekli değilse çağırmadı.
        */


        //FetchType.EAGER
        Student09 st1=session.get(Student09.class,1002);//bu satırı tek çalıştırdığımızda hibernate bize  Student sınıfını ve id ile Book sınıfını join edip bookları da getirdi.Gerekli olmasa bile FetchType.EAGER tüm chil class bilgilerini getirr. bu yüzden yavaştır



        tx.commit();//info will be send to DB
        session.close();
        sf.close();

        //FetchType.EAGER ile tüm bilgileri aldığımız için session kapandıktan sonra bile kullanabilirz
        //Eager ın güçlü yanı bu
        for(Book04 book: st1.getBookList()){
            System.out.println(book);
        }

    }
}
