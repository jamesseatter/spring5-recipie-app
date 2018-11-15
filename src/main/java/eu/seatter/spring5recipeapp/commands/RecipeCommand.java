package eu.seatter.spring5recipeapp.commands;

import eu.seatter.spring5recipeapp.domain.Difficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: jas
 * Date: 13/11/2018
 * Time: 12:45
 */
@Setter
@Getter
@NoArgsConstructor
public class RecipeCommand {
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Set<IngredientCommand> ingredients = new HashSet<>();
    private Byte[] image;
    private Difficulty difficulty;
    private NoteCommand note;
    private Set<CategoryCommand> categories = new HashSet<>();
}
