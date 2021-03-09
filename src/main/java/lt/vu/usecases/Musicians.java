package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Musician;
import lt.vu.persistence.MusicianDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Musicians {

    @Inject
    private MusicianDAO musicianDAO;

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
        this.musicianDAO.persist(musicianToCreate);
        return "success";
    }

    private void loadAllTeams(){
        this.allMusicians = musicianDAO.loadAll();
    }
}
