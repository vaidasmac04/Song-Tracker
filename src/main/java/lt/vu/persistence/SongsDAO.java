package lt.vu.persistence;

import lombok.Setter;
import lt.vu.entities.Album;
import lt.vu.entities.Genre;
import lt.vu.entities.Musician;
import lt.vu.entities.Song;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
public class SongsDAO {
    @PersistenceContext
    @Setter
    private EntityManager em;

    public void persist(Song song){
        this.em.persist(song);
    }

    public void merge(Song song) {
        this.em.merge(song);
    }

    public Song findOne(Integer id) { return em.find(Song.class, id); }

    public List<Song> loadAll() {
        return em.createNamedQuery("Song.findAll", Song.class).getResultList();
    }

    public Song loadSingleFully(Integer songId){
        Query query = em.createNamedQuery("Song.loadSingleFully",
                Song.class);
        query.setParameter("songId", songId);

        return (Song) query.getSingleResult();
    }
}
