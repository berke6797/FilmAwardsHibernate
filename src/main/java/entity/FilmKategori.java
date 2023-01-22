package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class FilmKategori {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kategoriId;
    private String kategoriIsim;


    public FilmKategori(int kategoriId, String kategoriIsim) {
        this.kategoriId = kategoriId;
        this.kategoriIsim = kategoriIsim;
    }

    public FilmKategori(String kategoriIsim) {
        this.kategoriIsim = kategoriIsim;
    }
}
