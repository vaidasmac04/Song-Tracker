package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Singer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String stageName;

    public Singer(){

    }

    public Singer(String firstName, String lastName, String stageName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.stageName = stageName;
    }
}
