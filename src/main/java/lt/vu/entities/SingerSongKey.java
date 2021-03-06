package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class SingerSongKey implements Serializable {
    private Integer singerId;

    private Integer songId;

    public SingerSongKey() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingerSongKey that = (SingerSongKey) o;
        return singerId.equals(that.singerId) && songId.equals(that.songId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(singerId, songId);
    }
}
