package candyBar.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

public class Ingredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    @ManyToMany
    private Set<CandyBar> presentIn;

    @OneToMany
    private Country sourceCountry;
}
