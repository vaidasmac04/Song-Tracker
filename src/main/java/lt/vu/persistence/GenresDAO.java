package lt.vu.persistence;

import lt.vu.entities.Genre;
import lt.vu.entities.Musician;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class GenresDAO {
    @PersistenceContext
    private EntityManager em;

    public List<Genre> loadAll() {
        return em.createNamedQuery("Genre.findAll", Genre.class).getResultList();
    }

    public Genre findOne(Integer id) {
        return em.find(Genre.class, id);
    }

    public void persist(Genre genre) {
        this.em.persist(genre);
    }

    public void merge(Genre genre) {
        this.em.merge(genre);
    }
}
