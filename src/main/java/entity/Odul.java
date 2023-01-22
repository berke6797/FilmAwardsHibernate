package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Odul {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int odulId ;
    private String odulAd;

    public Odul(int odulId, String odulAd) {
        this.odulId = odulId;
        this.odulAd = odulAd;
    }

    public Odul(String odulAd) {
        this.odulAd = odulAd;
    }
}
