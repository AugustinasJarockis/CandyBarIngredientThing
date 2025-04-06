package candyBar.usecases;

import candyBar.entities.CandyBar;
import candyBar.entities.Ingredient;
import candyBar.persistence.CandyBarsDAO;
import candyBar.persistence.IngredientsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ViewScoped
@Named
@Getter
@Setter
public class CandyBarDetails implements Serializable {
    private CandyBar candyBar;
    private ArrayList<SelectItem> addableIngredients = new ArrayList<>();
    @Inject
    private CandyBarsDAO candyBarsDAO;
    @Inject
    private IngredientsDAO ingredientsDAO;
    @Getter @Setter
    private String SelectedIngredient;
    @PostConstruct
    private void init() {
        System.out.println("CandyBarsDetails INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer candyBarId = Integer.parseInt(requestParameters.get("candyBarId"));
        this.candyBar = candyBarsDAO.findOne(candyBarId);

        List<Ingredient> allIngredients = ingredientsDAO.loadAll();
        for (Ingredient ingredient : allIngredients) {
            if (!candyBar.getIngredients().contains(ingredient)) { //TODO: Prob neveikia
                addableIngredients.add(new SelectItem(ingredient.getId(), ingredient.getName()));
            }
        }
    }

    @Transactional
    public void addIngredient(){
        int selectedId = Integer.parseInt(this.SelectedIngredient);
        Ingredient ingredientToAdd = ingredientsDAO.findOne(selectedId);
        candyBar.getIngredients().add(ingredientToAdd);
        candyBarsDAO.merge(candyBar);
    }
}