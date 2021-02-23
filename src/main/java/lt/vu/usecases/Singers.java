package lt.vu.usecases;

import lombok.Getter;
import lt.vu.entities.Singer;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import java.util.ArrayList;
import java.util.List;

@Model
public class Singers {
    @Getter
    private List<Singer> allSingers;

    @PostConstruct
    public void init(){
        loadSingers();
    }

    public void loadSingers() {
        this.allSingers = getMockedSingers();
    }

    private List<Singer> getMockedSingers(){
        List<Singer> singers = new ArrayList<>();
        singers.add(new Singer("Billie", "Eilish", "Billie Eilish"));
        singers.add(new Singer("Taylor", "Swift", "Taylor Swift"));
        singers.add(new Singer("Ed", "Sheeran", "Ed Sheeran"));
        singers.add(new Singer("Shawn", "Mendes", "Shawn Mendes"));
        singers.add(new Singer("Selena", "Gomez", "Selena Gomez"));
        singers.add(new Singer("Abel", "Tesfaye", "The Weeknd"));
        return singers;
    }
}
