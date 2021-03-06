package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Song;
import lt.vu.persistence.SongsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Songs {
    @Inject
    private SongsDAO songsDAO;

    @Getter
    @Setter
    private Song songToCreate = new Song();

    @Getter
    private List<Song> allSongs;

    @PostConstruct
    public void init(){
        loadSongs();
    }

    public void loadSongs() {
        this.allSongs = songsDAO.loadAll();
    }

    @Transactional
    public String createSong(){
        this.songsDAO.persist(songToCreate);
        return "success";
    }
}
