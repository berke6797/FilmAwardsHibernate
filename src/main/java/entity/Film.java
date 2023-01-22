package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int filmId;
    private String filmAd;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<FilmKategori>  filmKategoriList;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Odul> odulList;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Oyuncu> oyuncuList;
    @ManyToOne(cascade = CascadeType.ALL)
    private Yonetmen yonetmen;

    public Film(int filmId, String filmAd, List<FilmKategori> filmKategoriList, List<Odul> odulList, List<Oyuncu> oyuncuList, Yonetmen yonetmen) {
        this.filmId = filmId;
        this.filmAd = filmAd;
        this.filmKategoriList = filmKategoriList;
        this.odulList = odulList;
        this.oyuncuList = oyuncuList;
        this.yonetmen = yonetmen;
    }

    public Film(String filmAd, List<FilmKategori> filmKategoriList, List<Odul> odulList, List<Oyuncu> oyuncuList, Yonetmen yonetmen) {
        this.filmAd = filmAd;
        this.filmKategoriList = filmKategoriList;
        this.odulList = odulList;
        this.oyuncuList = oyuncuList;
        this.yonetmen = yonetmen;
    }

    public Film(String filmAd) {
        this.filmAd = filmAd;
    }
}
