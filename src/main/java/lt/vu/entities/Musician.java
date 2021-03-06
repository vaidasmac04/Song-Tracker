package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Musician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String stageName;

    @OneToMany(mappedBy = "musician")
    List<MusicianSong> musicianSongs = new ArrayList<>();


    public Musician(){

    }

    public Musician(String stageName) {
        this.stageName = stageName;
    }
}
