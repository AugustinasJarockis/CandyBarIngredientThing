package candyBar.rest.contracts;

import candyBar.entities.SourceContract;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
public class IngredientDTO {
    private Integer id;
    private String name;
    private Set<SourceContract> sourceContracts;
}
