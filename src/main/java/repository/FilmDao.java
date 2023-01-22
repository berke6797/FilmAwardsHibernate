package repository;

import entity.Film;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class FilmDao implements ICrud<Film> {
    @Override
    public void save(Film film) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(film);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getAll() {
        List<Object[]> filmListesi = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String getQuery = "select F.filmId,F.filmAd,FK.kategoriIsim,O.odulAd,Oy.oyuncuAd,Oy.oyuncuSoyad,Y.yonetmenAd,Y.yonetmenSoyad from Film as F \n" +
                    "inner join Film_FilmKategori as ffk on F.filmId=ffk.Film_filmId\n" +
                    "inner join FilmKategori as FK on FK.kategoriId=ffk.filmKategoriList_kategoriId\n" +
                    "inner join Film_Odul as fo on F.filmId=fo.Film_filmId\n" +
                    "inner join Odul as O on fo.odulList_odulId=O.odulId\n" +
                    "inner join Film_Oyuncu as FMO on FMO.Film_filmId=F.filmId\n" +
                    "inner join Oyuncu as Oy on Oy.oyuncuId=FMO.oyuncuList_oyuncuId\n" +
                    "inner join Yonetmen as Y on Y.yonetmenId=F.yonetmen_yonetmenId\n" +
                    "\n";
            filmListesi = entityManager.createNativeQuery(getQuery).getResultList();

            for (Object[] item : filmListesi) {
                System.out.println(
                                 " Film ID : " + item[0] + "  "
                                + " Film Ad : " + item[1] + "  "
                                + " Kategori adı : " + item[2] + "  "
                                + " Ödül Adı : " + item[3] + "  "
                                + " Oyuncu Adı : " + item[4] + "  "
                                + " Oyuncu Soyadı : " + item[5] + "  "
                                + " Yönetmen Adı: : " + item[6] + "  "
                                + " Yönetmen Soyadı: " + item[7] + "  "
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Film film) {
        Session session= null;
        try{
             session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(film);
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
        Film film=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            film=session.load(Film.class,id);
            session.delete(film);
            session.getTransaction().commit();
            System.out.println(id+" ' idli Film silindi");
        }catch (Exception e){
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


}
