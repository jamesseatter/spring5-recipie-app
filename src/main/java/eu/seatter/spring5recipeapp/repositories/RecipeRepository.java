package eu.seatter.spring5recipeapp.repositories;

import eu.seatter.spring5recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
