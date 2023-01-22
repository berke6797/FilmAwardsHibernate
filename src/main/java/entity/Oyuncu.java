package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Oyuncu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oyuncuId;
    private String oyuncuAd;
    private String oyuncuSoyad;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Odul>  odulList;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Film>  filmList;

    public Oyuncu(int oyuncuId, String oyuncuAd, String oyuncuSoyad, List<Odul> odulList, List<Film> filmList) {
        this.oyuncuId = oyuncuId;
        this.oyuncuAd = oyuncuAd;
        this.oyuncuSoyad = oyuncuSoyad;
        this.odulList = odulList;
        this.filmList = filmList;
    }

    public Oyuncu(String oyuncuAd, String oyuncuSoyad, List<Odul> odulList, List<Film> filmList) {
        this.oyuncuAd = oyuncuAd;
        this.oyuncuSoyad = oyuncuSoyad;
        this.odulList = odulList;
        this.filmList = filmList;
    }

    public Oyuncu(String oyuncuAd, String oyuncuSoyad) {
        this.oyuncuAd = oyuncuAd;
        this.oyuncuSoyad = oyuncuSoyad;
    }
}
