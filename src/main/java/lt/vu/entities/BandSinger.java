package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class BandSinger {
    @EmbeddedId
    private BandSingerKey id;

    private short YearFrom;
    private short YearTo;

    @ManyToOne
    @MapsId("groupId")
    private Band band;

    @ManyToOne
    @MapsId("singerId")
    private Singer singer;

    public BandSinger() {
    }
}
