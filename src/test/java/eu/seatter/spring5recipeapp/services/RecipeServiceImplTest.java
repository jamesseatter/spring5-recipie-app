package eu.seatter.spring5recipeapp.services;

import eu.seatter.spring5recipeapp.domain.Recipe;
import eu.seatter.spring5recipeapp.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
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
    private RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() {
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
    }
}