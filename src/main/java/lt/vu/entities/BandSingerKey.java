package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class BandSingerKey implements Serializable {
    private Integer singerId;

    private Integer groupId;

    public BandSingerKey() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BandSingerKey that = (BandSingerKey) o;
        return singerId.equals(that.singerId) && groupId.equals(that.groupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(singerId, groupId);
    }
}
