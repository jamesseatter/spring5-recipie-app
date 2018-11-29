package eu.seatter.spring5recipeapp.services;

import eu.seatter.spring5recipeapp.commands.IngredientCommand;
import eu.seatter.spring5recipeapp.converters.IngredientToIngredientCommand;
import eu.seatter.spring5recipeapp.domain.Recipe;
import eu.seatter.spring5recipeapp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * User: jas
 * Date: 20/11/2018
 * Time: 14:30
 */
@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final RecipeRepository recipeRepository;

    public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand, RecipeRepository recipeRepository) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if(!recipeOptional.isPresent()) {
            //todo impl error handling
            log.error("recipe id not found id: " + recipeId);
        }

        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional  = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredient -> ingredientToIngredientCommand.convert(ingredient)).findFirst();

        if(!ingredientCommandOptional.isPresent()) {
            //todo impl error handling
            log.error("ingredient id not found id: " + ingredientId);
        }

        return ingredientCommandOptional.get();
    }
}