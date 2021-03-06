package lt.vu.persistence;

import lombok.Setter;
import lt.vu.entities.Song;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class SongsDAO {
    @PersistenceContext
    @Setter
    private EntityManager em;

    public List<Song> loadAll() {
        return em.createNamedQuery("Song.findAll", Song.class).getResultList();
    }

    public void persist(Song song){
        this.em.persist(song);
    }
}
