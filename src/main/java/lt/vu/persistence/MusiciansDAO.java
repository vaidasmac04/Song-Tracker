package lt.vu.persistence;

import lombok.Setter;
import lt.vu.entities.Musician;
import lt.vu.entities.Song;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class MusiciansDAO {

    @PersistenceContext
    private EntityManager em;

    public List<Musician> loadAll() {
        return em.createNamedQuery("Musician.findAll", Musician.class).getResultList();
    }

    public void persist(Musician musician){
        this.em.persist(musician);
    }

    public Musician findOne(Integer id) { return em.find(Musician.class, id); }
}
