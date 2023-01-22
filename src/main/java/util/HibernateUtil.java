package util;

import entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory=null;
    public static SessionFactory getSessionFactory(){
        if(sessionFactory==null){
            try{
                Configuration configuration= new Configuration();
                configuration.addAnnotatedClass(Odul.class);
                configuration.addAnnotatedClass(FilmKategori.class);
                configuration.addAnnotatedClass(Film.class);
                configuration.addAnnotatedClass(Oyuncu.class);
                configuration.addAnnotatedClass(Yonetmen.class);
                sessionFactory=configuration.configure(
                        "hibernate.cfg.xml").buildSessionFactory();
            }catch (Exception e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
        return sessionFactory;
    }
}
