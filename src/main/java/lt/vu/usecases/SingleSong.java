package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Album;
import lt.vu.entities.Genre;
import lt.vu.entities.Musician;
import lt.vu.entities.Song;
import lt.vu.persistence.AlbumsDAO;
import lt.vu.persistence.GenresDAO;
import lt.vu.persistence.MusiciansDAO;
import lt.vu.persistence.SongsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.*;

@Model
public class SingleSong {
    @Inject
    private AlbumsDAO albumsDAO;

    @Inject
    private MusiciansDAO musiciansDAO;

    @Inject
    private SongsDAO songsDAO;

    @Inject
    private GenresDAO genresDAO;

    @Getter
    @Setter
    private List<Genre> availableGenres;

    @Getter
    @Setter
    private Song song;

    @Getter
    @Setter
    private List<Integer> genresId;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        Integer songId = Integer.parseInt(requestParameters.get("songId"));
        song = songsDAO.loadSingleFully(songId);
        prepareSong();
        availableGenres = loadAvailableGenres();
        genresId = loadCurrentGenresId();
    }

    private List<Integer> loadCurrentGenresId() {
        List<Integer> currentGenresId = new ArrayList<>();
        List<Genre> currentGenres = new ArrayList<>(song.getGenres());
        for(Genre g : currentGenres){
            currentGenresId.add(g.getId());
        }
        return currentGenresId;
    }

    private List<Genre> loadAvailableGenres(){
        List<Genre> genres = new ArrayList<>();

        if(song.getAlbum().getId() == 0){
            genres.addAll(genresDAO.loadAll());
        }
        else{
            for(Genre g : genresDAO.loadAll()){
              if(!song.getGenres().contains(g)){
                  genres.add(g);
              }
            }
        }

        return genres;
    }

    @Transactional
    public String updateSong(){
        if(song.getMusician().getId() != 0){
            song.setMusician(musiciansDAO.findOne(song.getMusician().getId()));
        }

        if(song.getAlbum().getId() != 0){
            song.setAlbum(albumsDAO.findOne(song.getAlbum().getId()));
        }

        updateGenres();
        songsDAO.merge(song);

        return "song-details?faces-redirect=true&songId="+song.getId();
    }

    private void prepareSong() {
        if(song.getMusician() == null){
            Musician musician = new Musician();
            musician.setId(0);
            musician.setStageName("none");
            song.setMusician(musician);
        }

        if(song.getAlbum() == null){
            Album album = new Album();
            album.setId(0);
            song.setAlbum(album);
        }

        if(song.getGenres() == null){
            Set<Genre> genres = new HashSet<>();
            song.setGenres(genres);
        }
    }

    private void updateGenres() {
        List<Genre> oldGenres = new ArrayList<>(song.getGenres());
        List<Genre> newGenres = new ArrayList<>(loadNewGenres());

        for(Genre g : newGenres){
            if(!oldGenres.contains(g)){
                song.getGenres().add(g);
            }
        }

        for(Genre g : oldGenres){
            if(!newGenres.contains(g)){
                song.getGenres().remove(g);
            }
        }
    }

    private Set<Genre> loadNewGenres(){
        Set<Genre> genres = new HashSet<>();
        for(Integer id : genresId){
            genres.add(genresDAO.findOne(id));
        }
        return genres;
    }
}
