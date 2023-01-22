package service;

import entity.Film;
import entity.Odul;
import entity.Yonetmen;
import repository.YonetmenDao;

import java.util.Arrays;

public class YonetmenService {
     static YonetmenDao yonetmenDao= new YonetmenDao();
    public static void main(String[] args) {
       // save();
        //getAll();
      //  update(10);
      //  delete(9);
    }
    public static void save(){

            Film film7 = new Film("Film 7");
            Film film8 = new Film("Film 8");
            Odul odul7 = new Odul("Ödül 7");
            Odul odul8 = new Odul("Ödül 8");
            Odul odul9= new Odul("Ödül 9");

            Yonetmen yonetmen4 = new Yonetmen(
                    "Cenk",
                    "Ergüvan",
                    Arrays.asList(odul7),
                    Arrays.asList(film7));
            Yonetmen yonetmen5 = new Yonetmen(
                    "Emre",
                    "Kazancı",
                    Arrays.asList(odul8,odul9),
                    Arrays.asList(film8));
            yonetmenDao.save(yonetmen5);

    }

    public static  void getAll(){
        try{
            yonetmenDao.getAll();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public  static  void  update(int id){
        try {
            Odul odul1 = new Odul("Yılın en çok bağış yapan yönetmeni");
            Odul odul2 = new Odul("Yılın en çok kazanan  yönetmeni");
            Film film55= new Film("Japon efsanesi");
            Film film56= new Film("Kılıç Ustasi");
            Yonetmen yonetmen= new Yonetmen(id,"Akira ","Kurusowa",Arrays.asList(odul1,odul2),Arrays.asList(film55,film56));
            yonetmenDao.update(yonetmen);
            System.out.println(id+" 'li yönetmen bilgileri güncellendi...");
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        getAll();
    }
    public static void delete(int id ){
        try {
            yonetmenDao.delete(id);
            System.out.println(id+" 'li yonetmen silidi ...");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        getAll();
    }

    }


