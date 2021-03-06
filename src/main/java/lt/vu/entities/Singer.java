package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Singer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String stageName;

    @OneToMany(mappedBy = "singer")
    List<BandSinger> bandSingers = new ArrayList<>();

    @OneToMany(mappedBy = "singer")
    List<SingerSong> singerSongs = new ArrayList<>();

    public Singer(){

    }

    public Singer(String firstName, String lastName, String stageName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.stageName = stageName;
    }
}
