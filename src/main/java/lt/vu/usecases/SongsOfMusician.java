package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Musician;
import lt.vu.entities.Song;
import lt.vu.persistence.MusicianDAO;
import lt.vu.persistence.SongsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class SongsOfMusician {
    @Inject
    private MusicianDAO musicianDAO;

    @Inject
    private SongsDAO songsDAO;

    @Getter
    @Setter
    private Musician musician;

    @Getter
    @Setter
    private Song songToCreate = new Song();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer musicianId = Integer.parseInt(requestParameters.get("musicianId"));
        this.musician = musicianDAO.findOne(musicianId);
    }

    @Transactional
    public String createSong() {
        songToCreate.setMusician(this.musician);
        songsDAO.persist(songToCreate);
        return "/musician-songs.xhtml?faces-redirect=true&musicianId=" + this.musician.getId();
    }
}
