package repository;

import entity.Oyuncu;
import entity.Yonetmen;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class YonetmenDao implements ICrud<Yonetmen>{
    @Override
    public void save(Yonetmen yonetmen) {
        try{
            Session session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(yonetmen);
            session.getTransaction().commit();
            session.close();

        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getAll() {
        List<Object[]> yonetmenList= null;
        try {
            EntityManager entityManager= HibernateUtil.getSessionFactory().createEntityManager();
            String query="select y.yonetmenId,y.yonetmenAd,y.yonetmenSoyad,od.odulAd,f.filmAd from Yonetmen as y \n" +
                    "inner join Yonetmen_Odul as yo on y.yonetmenId=yo.Yonetmen_yonetmenId\n" +
                    "inner join Odul as od on od.odulId=yo.yonetmenOdulList_odulId\n" +
                    "inner join Yonetmen_Film as yf on yf.Yonetmen_yonetmenId=y.yonetmenId\n" +
                    "inner join Film as f on f.filmId=yf.yonetilenFilmler_filmId";
            yonetmenList = entityManager.createNativeQuery(query).getResultList();

            for (Object[] item : yonetmenList) {
                System.out.println(
                        " Yönetmen ID : " + item[0] + "  "
                                + " Yönetmen Ad : " + item[1] + "  "
                                + " Yönetmen Soyad : " + item[2] + "  "
                                + " Yönetmenin aldığı  ödüller : " + item[3] + "  "
                                + " Yönetmenin  filmleri : " + item[4] + "  ");}

        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Yonetmen yonetmen) {
        Session session= null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(yonetmen);
            session.getTransaction().commit();
            session.close();

        }catch (Exception e){
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        Session session=null;
        Yonetmen yonetmen=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            yonetmen=session.load(Yonetmen.class,id);
            session.delete(yonetmen);
            session.getTransaction().commit();
            System.out.println(id+" ' idli yonetmen silindi");
        }catch (Exception e){
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
