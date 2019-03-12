package eu.seatter.spring5recipeapp.services;

import eu.seatter.spring5recipeapp.converters.RecipeCommandToRecipe;
import eu.seatter.spring5recipeapp.converters.RecipeToRecipeCommand;
import eu.seatter.spring5recipeapp.domain.Recipe;
import eu.seatter.spring5recipeapp.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * Created by IntelliJ IDEA.
 * User: jas
 * Date: 05/11/2018
 * Time: 13:58
 */
public class RecipeServiceImplTest {

    private RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test
    public void getRecipesTest() {
        // Create a mock for the test
        // new recipe
        Recipe recipe = new Recipe();
        // new Set of recipes
        HashSet recipeData = new HashSet();
        recipeData.add(recipe);

        // then recipeService.getRecipes is called return the Set created above
        when(recipeService.getRecipes()).thenReturn(recipeData);

        // execute the test using the mock.
        Set<Recipe> recipes = recipeService.getRecipes();

        assertEquals(1,recipes.size());
        // verify that the findAll method was called only once (1)
        verify(recipeRepository,times(1)).findAll();
        verify(recipeRepository, never()).findById(anyLong());
    }

    @Test
    public void getRecipesByIdTest() {
        // Create a mock for the test
        // new recipe
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        // then recipeService.getRecipes is called return the Set created above
        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById(1L);

        assertNotNull("Null recipe returned",recipeReturned);
        // verify that the findAll method was called only once (1)
        verify(recipeRepository,times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }

    @Test
    public void testDeleteById() {
        // given
        Long idToDelete = 2L;

        // when
        recipeService.deleteById(idToDelete);

        //then
        verify(recipeRepository, times(1)).deleteById(anyLong());

    }
}