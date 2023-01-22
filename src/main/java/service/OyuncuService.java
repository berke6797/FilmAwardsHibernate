package service;

import entity.*;
import repository.OyuncuDao;

import java.util.Arrays;

public class OyuncuService {
    static OyuncuDao oyuncuDao = new OyuncuDao();

    public static void main(String[] args) {

        //save();
         // getAll();
        // update(7);
      //  delete(24);
        getOyuncuByFilmAdi("Film 5");
    }

    public static void save() {

        Odul odul5 = new Odul("Ödül 5");
        Odul odul6 = new Odul("Ödül 6");

        Film film5 = new Film("Film 5");
        Film film6 = new Film("Film 6");

        Oyuncu oyuncu5 = new Oyuncu(
                "Halil",
                "Kazancı",
                Arrays.asList(odul5),
                Arrays.asList(film5));

        Oyuncu oyuncu6 = new Oyuncu(
                "Kutay",
                "Ozgur",
                Arrays.asList(odul6),
                Arrays.asList(film5, film6));

        oyuncuDao.save(oyuncu6);

    }

    public static void getAll() {
        try {
            oyuncuDao.getAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void update(int id) {
        try {
            Odul odul1 = new Odul("Yılın en titiz oyuncusu ödülü");
            FilmKategori filmKategori1 = new FilmKategori("Dram");
            FilmKategori filmKategori2 = new FilmKategori("Macera");
            Film film1 = new Film("Titanik");
            Oyuncu oyuncu1 = new Oyuncu(id, "Berke", "Kazancı", Arrays.asList(odul1), Arrays.asList(film1));
            oyuncuDao.update(oyuncu1);
            System.out.println(id + " id'li oyuncu bilgileri güncellendi");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        getAll();

    }

    public static void delete(int id) {
        try {
            oyuncuDao.delete(id);
            System.out.println(id+" 'li oyuncu silidi ...");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        getAll();
    }
    public static void getOyuncuByFilmAdi(String filmAdı){
        try {
            oyuncuDao.getOyuncuByFilmAdi(filmAdı);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
