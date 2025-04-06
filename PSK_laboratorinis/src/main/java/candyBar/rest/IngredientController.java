package candyBar.rest;

import candyBar.entities.Ingredient;
import candyBar.persistence.IngredientsDAO;
import candyBar.rest.contracts.IngredientDTO;
import lombok.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/ingredientDetails")
public class IngredientController {
    @Inject
    @Setter
    @Getter
    private IngredientsDAO ingredientsDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Ingredient ingredient = ingredientsDAO.findOne(id);
        if (ingredient == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        IngredientDTO ingredientDTO = new IngredientDTO();
        ingredientDTO.setId(ingredient.getId());
        ingredientDTO.setName(ingredient.getName());
        ingredientDTO.setSourceContracts(ingredient.getSourceContracts());

        return Response.ok(ingredientDTO).build();
    }
}