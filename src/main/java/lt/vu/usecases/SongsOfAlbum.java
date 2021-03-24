package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Album;
import lt.vu.entities.Musician;
import lt.vu.entities.Song;
import lt.vu.persistence.AlbumsDAO;
import lt.vu.persistence.MusiciansDAO;
import lt.vu.persistence.SongsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Model
public class SongsOfAlbum {
    @Inject
    private AlbumsDAO albumsDAO;

    @Inject
    private SongsDAO songsDAO;

    @Getter
    @Setter
    private Album album;

    @Getter
    @Setter
    private List<Song> allAlbumSongs = new ArrayList();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer albumId = Integer.parseInt(requestParameters.get("albumId"));
        this.album = albumsDAO.findOne(albumId);
        this.allAlbumSongs = songsDAO.findByAlbum(albumId);
    }
}
