package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Singer {
    private String firstName;
    private String lastName;
    private String stageName;

    public Singer(String firstName, String lastName, String stageName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.stageName = stageName;
    }
}
