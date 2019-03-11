package eu.seatter.spring5recipeapp.repositories;

import eu.seatter.spring5recipeapp.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by IntelliJ IDEA.
 * User: jas
 * Date: 04/12/2018
 * Time: 14:16
 */
public interface IngredientRepository extends CrudRepository <Ingredient, Long> {

}