package eu.seatter.spring5recipeapp.services;

import eu.seatter.spring5recipeapp.commands.IngredientCommand;
import eu.seatter.spring5recipeapp.converters.IngredientCommandToIngredient;
import eu.seatter.spring5recipeapp.converters.IngredientToIngredientCommand;
import eu.seatter.spring5recipeapp.converters.UnitOfMeasureCommandToUnitOfMeasure;
import eu.seatter.spring5recipeapp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import eu.seatter.spring5recipeapp.domain.Ingredient;
import eu.seatter.spring5recipeapp.domain.Recipe;
import eu.seatter.spring5recipeapp.repositories.RecipeRepository;
import eu.seatter.spring5recipeapp.repositories.UnitOfMeasureRepository;
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
    private final IngredientCommandToIngredient ingredientCommandToIngredient;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    IngredientService ingredientService;

    public IngredientServiceImplTest() {
        this.ingredientToIngredientCommand = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
        this.ingredientCommandToIngredient = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        ingredientService = new IngredientServiceImpl(ingredientToIngredientCommand,
                                                        ingredientCommandToIngredient,
                                                        recipeRepository,
                                                        unitOfMeasureRepository);
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

    @Test
    public void testSaveRecipeCommand() throws Exception {
        //given
        IngredientCommand command = new IngredientCommand();
        command.setId(3L);
        command.setRecipeId(2L);

        Optional<Recipe> recipeOptional = Optional.of(new Recipe());

        Recipe savedRecipe = new Recipe();
        savedRecipe.addIngredient(new Ingredient());
        savedRecipe.getIngredients().iterator().next().setId(3L);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
        when(recipeRepository.save(any())).thenReturn(savedRecipe);

        //when
        IngredientCommand savedCommand = ingredientService.saveIngredientCommand(command);

        //then
        assertEquals(Long.valueOf(3L), savedCommand.getId());
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, times(1)).save(any(Recipe.class));

    }
}