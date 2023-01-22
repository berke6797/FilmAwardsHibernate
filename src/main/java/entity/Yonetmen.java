package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Yonetmen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int yonetmenId;
    private String yonetmenAd;
    private String yonetmenSoyad;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Odul> yonetmenOdulList;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Film>  yonetilenFilmler;

    public Yonetmen(int yonetmenId, String yonetmenAd, String yonetmenSoyad, List<Odul> yonetmenOdulList, List<Film> yonetilenFilmler) {
        this.yonetmenId = yonetmenId;
        this.yonetmenAd = yonetmenAd;
        this.yonetmenSoyad = yonetmenSoyad;
        this.yonetmenOdulList = yonetmenOdulList;
        this.yonetilenFilmler = yonetilenFilmler;
    }

    public Yonetmen(String yonetmenAd, String yonetmenSoyad, List<Odul> yonetmenOdulList, List<Film> yonetilenFilmler) {
        this.yonetmenAd = yonetmenAd;
        this.yonetmenSoyad = yonetmenSoyad;
        this.yonetmenOdulList = yonetmenOdulList;
        this.yonetilenFilmler = yonetilenFilmler;
    }

    public Yonetmen(String yonetmenAd, String yonetmenSoyad, List<Film> yonetilenFilmler) {
        this.yonetmenAd = yonetmenAd;
        this.yonetmenSoyad = yonetmenSoyad;
        this.yonetilenFilmler = yonetilenFilmler;
    }

    public Yonetmen(String yonetmenAd, String yonetmenSoyad) {
        this.yonetmenAd = yonetmenAd;
        this.yonetmenSoyad = yonetmenSoyad;
    }
}
