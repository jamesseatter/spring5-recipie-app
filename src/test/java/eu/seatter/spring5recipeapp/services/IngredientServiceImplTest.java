package eu.seatter.spring5recipeapp.services;

import eu.seatter.spring5recipeapp.commands.IngredientCommand;
import eu.seatter.spring5recipeapp.converters.IngredientToIngredientCommand;
import eu.seatter.spring5recipeapp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import eu.seatter.spring5recipeapp.domain.Ingredient;
import eu.seatter.spring5recipeapp.domain.Recipe;
import eu.seatter.spring5recipeapp.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * Created by IntelliJ IDEA.
 * User: jas
 * Date: 27/11/2018
 * Time: 14:16
 */
public class IngredientServiceImplTest {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;

    @Mock
    RecipeRepository recipeRepository;

    IngredientService ingredientService;

    public IngredientServiceImplTest() {
        this.ingredientToIngredientCommand = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        ingredientService = new IngredientServiceImpl(ingredientToIngredientCommand, recipeRepository);
    }

    @Test
    public void findByRecipeIdAndIngredientId() {

    }

    @Test
    public void findByRecipeIdAndIngredientIdHappyPath() throws Exception {
        // given
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        Ingredient ingredient_1 = new Ingredient();
        ingredient_1.setId(1L);
        Ingredient ingredient_2 = new Ingredient();
        ingredient_2.setId(2L);
        Ingredient ingredient_3 = new Ingredient();
        ingredient_3.setId(3L);

        recipe.addIngredient(ingredient_1);
        recipe.addIngredient(ingredient_2);
        recipe.addIngredient(ingredient_3);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        //then
        IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId(1L,3L);

        //when
        assertEquals(Long.valueOf(3L),ingredientCommand.getId());
        assertEquals(Long.valueOf(1L),ingredientCommand.getRecipeId());
        verify(recipeRepository, times(1)).findById(anyLong());


    }
}