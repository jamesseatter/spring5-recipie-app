package eu.seatter.spring5recipeapp.services;

import eu.seatter.spring5recipeapp.commands.IngredientCommand;

/**
 * Created by IntelliJ IDEA.
 * User: jas
 * Date: 20/11/2018
 * Time: 14:30
 */
public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

    IngredientCommand saveIngredientCommand(IngredientCommand command);

    void deleteByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
}
