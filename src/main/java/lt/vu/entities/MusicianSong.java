package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.sql.Date;

@Entity
@Getter
@Setter
public class MusicianSong {
    @EmbeddedId
    private MusicianSongKey id;

    private Date ReleaseDate;

    @ManyToOne
    @MapsId("songId")
    private Song song;

    @ManyToOne
    @MapsId("singerId")
    private Musician musician;

    @ManyToOne
    private Album album;

    public MusicianSong() {
    }
}
