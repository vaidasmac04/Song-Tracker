package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "Musician.findAll", query = "select m from Musician as m")
})
public class Musician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String stageName;

    @OneToMany(mappedBy = "musician", fetch = FetchType.EAGER)
    private List<Song> songs = new ArrayList<>();

    @OneToMany(mappedBy = "musician")
    private List<Album> albums = new ArrayList<>();

    public Musician(){

    }
}
