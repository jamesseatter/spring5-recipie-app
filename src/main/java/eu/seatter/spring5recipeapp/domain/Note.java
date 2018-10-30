package eu.seatter.spring5recipeapp.domain;

import javax.persistence.*;

/**
 * Created by jas on 29/10/2018
 */
@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob    // Allows JPA to use a CLOB field in the DB to larger text can be stored than a DB Sdtring field.
    private String recipeNotes;

    public Note(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }

    public Note(String recipeNotes, Recipe recipe) {
        this.recipe = recipe;
        this.recipeNotes = recipeNotes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getRecipeNotes() {
        return recipeNotes;
    }

    public void setRecipeNotes(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }
}
