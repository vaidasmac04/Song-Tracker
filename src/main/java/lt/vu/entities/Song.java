package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

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

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Genre> genres = new HashSet<>();

    @ManyToOne
    private Album album;

    @ManyToOne
    private Musician musician;

    public Song(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return id.equals(song.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
