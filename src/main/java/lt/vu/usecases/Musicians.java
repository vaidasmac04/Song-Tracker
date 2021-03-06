package lt.vu.usecases;

import lombok.Getter;
import lt.vu.entities.Musician;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import java.util.ArrayList;
import java.util.List;

@Model
public class Musicians {
    @Getter
    private List<Musician> allMusicians;

    @PostConstruct
    public void init(){
        loadMusicians();
    }

    public void loadMusicians() {
        this.allMusicians = getMockedMusicians();
    }

    private List<Musician> getMockedMusicians(){
        List<Musician> musicians = new ArrayList<>();
        musicians.add(new Musician("Billie Eilish"));
        musicians.add(new Musician("Taylor Swift"));
        musicians.add(new Musician("Ed Sheeran"));
        musicians.add(new Musician("Shawn Mendes"));
        musicians.add(new Musician("Selena Gomez"));
        musicians.add(new Musician("The Weeknd"));
        return musicians;
    }
}
