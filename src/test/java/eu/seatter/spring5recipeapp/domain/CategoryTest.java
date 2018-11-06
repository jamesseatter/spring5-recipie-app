package eu.seatter.spring5recipeapp.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: jas
 * Date: 05/11/2018
 * Time: 13:52
 */
public class CategoryTest {

    private Category category;

    @Before
    public void setUp() {

        category = new Category();
        category.setId(4L);
    }

    @Test
    public void getId() {
        Long idValue = 4L;

        assertEquals(idValue,category.getId());
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void getRecipes() {
    }
}