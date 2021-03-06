package eu.seatter.spring5recipeapp.services;

import eu.seatter.spring5recipeapp.commands.RecipeCommand;
import eu.seatter.spring5recipeapp.domain.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long id);

    RecipeCommand findCommandById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(Long id);
}
