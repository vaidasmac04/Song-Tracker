package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Musician;
import lt.vu.persistence.MusiciansDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Musicians {

    @Inject
    private MusiciansDAO musiciansDAO;

    @Getter
    @Setter
    private Musician musicianToCreate = new Musician();

    @Getter
    private List<Musician> allMusicians;

    @PostConstruct
    public void init(){
        loadAllTeams();
    }

    @Transactional
    public String createMusician(){
        this.musiciansDAO.persist(musicianToCreate);
        return "index?faces-redirect=true";
    }

    private void loadAllTeams(){
        this.allMusicians = musiciansDAO.loadAll();
    }
}
