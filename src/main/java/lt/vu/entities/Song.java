package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "Song.findAll", query = "select s from Song as s")
})

public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Date releaseDate;

    @ManyToMany
    private List<Genre> genres = new ArrayList<>();

    @ManyToOne
    private Album album;

    @ManyToOne
    private Musician musician;

    public Song(){

    }
}
