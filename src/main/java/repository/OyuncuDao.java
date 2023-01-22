package repository;

import entity.Film;
import entity.Oyuncu;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.text.html.parser.Entity;
import java.util.List;

public class OyuncuDao implements ICrud<Oyuncu> {
    @Override
    public void save(Oyuncu oyuncu) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(oyuncu);
            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getAll() {
        List<Object[]> oyuncuListesi = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "select O.oyuncuId,O.oyuncuAd,O.oyuncuSoyad,od.odulAd,f.filmAd from Oyuncu as o \n" +
                    "inner join Oyuncu_Film as o_f on O.oyuncuId=o_f.Oyuncu_oyuncuId\n" +
                    "inner join Film as f on f.filmId=o_f.filmList_filmId \n" +
                    "inner join Oyuncu_Odul as oo on oo.Oyuncu_oyuncuId=o.oyuncuId\n" +
                    "inner join Odul as od on od.odulId=oo.odulList_odulId";
            oyuncuListesi = entityManager.createNativeQuery(query).getResultList();

            for (Object[] item : oyuncuListesi) {
                System.out.println(
                        " Oyuncu ID : " + item[0] + "  "
                                + " Oyuncu Ad : " + item[1] + "  "
                                + " Oyuncu Soyad : " + item[2] + "  "
                                + " Ödül Adı : " + item[3] + "  "
                                + " Oynadığı filmler : " + item[4] + "  ");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Oyuncu oyuncu) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(oyuncu);
            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

        Session session = null;
        Oyuncu oyuncu = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            oyuncu = session.load(Oyuncu.class, id);
            session.delete(oyuncu);
            session.getTransaction().commit();
            System.out.println(id + " ' idli oyuncu silindi");
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void getOyuncuByFilmAdi(String filmad) {
        List<Oyuncu[]> oyuncuListesi = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String sql = "select O.oyuncuId,O.oyuncuAd,O.oyuncuSoyad,od.odulAd from Oyuncu as o \n" +
                    "inner join Oyuncu_Film as o_f on O.oyuncuId=o_f.Oyuncu_oyuncuId\n" +
                    "inner join Film as f on f.filmId=o_f.filmList_filmId \n" +
                    "inner join Oyuncu_Odul as oo on oo.Oyuncu_oyuncuId=o.oyuncuId\n" +
                    "inner join Odul as od on od.odulId=oo.odulList_odulId where f.filmAd= ? ;";
            Query query = entityManager.createNativeQuery(sql);
            query.setParameter(1, filmad);
            oyuncuListesi = query.getResultList();
            if (oyuncuListesi.isEmpty()) {
                System.out.println("Bu filmde ödül almış oyuncu yoktur....");
            } else {
                for (Object[] item : oyuncuListesi) {
                    System.out.println(
                            " Oyuncu ID : " + item[0] + "  "
                                    + " Oyuncu Ad : " + item[1] + "  "
                                    + " Oyuncu Soyad : " + item[2] + "  "
                                    + " Ödül Adı : " + item[3]
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
