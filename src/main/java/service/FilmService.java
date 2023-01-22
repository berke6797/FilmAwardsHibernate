package service;

import entity.*;
import repository.FilmDao;

import java.util.Arrays;

public class FilmService {
    static FilmDao filmDao = new FilmDao();

    public static void main(String[] args) {

        // save();
        // update(4);
        // getAll();
        //  delete(9);
    }

    public static void save() {
        Odul odul1 = new Odul("Ödül 1");
        Odul odul2 = new Odul("Ödül 2");
        Odul odul3 = new Odul("Ödül 3");
        Odul odul4 = new Odul("Ödül 4");
        Oyuncu oyuncu1 = new Oyuncu("Oyuncu1 Ad", "Oyuncuc1 Soyad");
        Oyuncu oyuncu2 = new Oyuncu("Oyuncu2 Ad", "Oyuncu2 Soyad");
        Oyuncu oyuncu3 = new Oyuncu("Oyuncu3 Ad", "Oyuncu3 Soyad");

        FilmKategori filmKategori1 = new FilmKategori("Kategori 1");
        FilmKategori filmKategori2 = new FilmKategori("Kategori 2");
        FilmKategori filmKategori3 = new FilmKategori("Kategori 3");
        Film film1 = new Film(
                "Film 1",
                Arrays.asList(filmKategori1, filmKategori2),
                Arrays.asList(odul1, odul2),
                Arrays.asList(oyuncu1, oyuncu2),
                new Yonetmen("Yönetmen1 Ad", "Yönetmen1 Soyad"));
        Film film2 = new Film(
                "Film 2",
                Arrays.asList(filmKategori2),
                Arrays.asList(odul1, odul3),
                Arrays.asList(oyuncu1, oyuncu3),
                new Yonetmen("Yönetmen2 Ad", "Yönetmen2 Soyad"));
        Film film3 = new Film(
                "Film 3",
                Arrays.asList(filmKategori3),
                Arrays.asList(odul2, odul4),
                Arrays.asList(
                        new Oyuncu("Oyuncu3 Ad", "Oyuncu3 Soyad"),
                        new Oyuncu("Oyuncu4 Ad", "Oyuncu4 Soyad")),
                new Yonetmen("Yönetmen3 Ad", "Yönetmen3 Soyad"));
        Film film4 = new Film(
                "Dabbe 6",
                Arrays.asList(new FilmKategori("Korku")),
                Arrays.asList(new Odul("Yılın en korkunç filmi")),
                Arrays.asList(new Oyuncu("Ümit", "Acar")),
                new Yonetmen("Hasan", "Karacadağ"));
        filmDao.save(film4);
    }

    public static void getAll() {
        try {
            filmDao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void update(int id) {
        try {
            Odul odul1 = new Odul("Yılın en tarz oyuncusu ödülü");
            Odul odul2 = new Odul("Yılın en yakışıklı oyuncusu ödülü");
            FilmKategori filmKategori = new FilmKategori("Macera");
            Oyuncu oyuncu1 = new Oyuncu("Orkun", "Karalahana");
            Oyuncu oyuncu2 = new Oyuncu("Mehmet", "Salatalık");
            Yonetmen yonetmen1 = new Yonetmen("Burak", "Sevinç");
            Film film1 = new Film(id, "Denizlere açılıyorum", Arrays.asList(filmKategori), Arrays.asList(odul1, odul2), Arrays.asList(oyuncu1, oyuncu2), yonetmen1);
            filmDao.update(film1);
            System.out.println(id + " id'li film bilgileri güncellendi");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        getAll();

    }

    public static void delete(int id) {
        try {
            filmDao.delete(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        getAll();
    }
}
