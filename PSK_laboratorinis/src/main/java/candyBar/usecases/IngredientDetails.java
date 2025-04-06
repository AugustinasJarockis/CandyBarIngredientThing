package candyBar.usecases;

import candyBar.entities.Ingredient;
import candyBar.persistence.IngredientsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class IngredientDetails implements  Serializable{
    private Ingredient ingredient;

    @Inject
    private IngredientsDAO ingredientDAO;

    @PostConstruct
    private void init() {
        System.out.println("IngredientDetails INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer ingredientId = Integer.parseInt(requestParameters.get("ingredientId"));
        this.ingredient = ingredientDAO.findOne(ingredientId);
    }

//    @Transactional
//    public String updatePlayerJerseyNumber() {
//        try{
//            playersDAO.update(this.player);
//        } catch (OptimisticLockException e) {
//            return "/playerDetails.xhtml?faces-redirect=true&playerId=" + this.player.getId() + "&error=optimistic-lock-exception";
//        }
//        return "players.xhtml?teamId=" + this.player.getTeam().getId() + "&faces-redirect=true";
//    }
}
