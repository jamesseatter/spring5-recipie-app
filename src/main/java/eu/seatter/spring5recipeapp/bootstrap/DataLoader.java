package eu.seatter.spring5recipeapp.bootstrap;

import eu.seatter.spring5recipeapp.domain.*;
import eu.seatter.spring5recipeapp.repositories.CategoryRepository;
import eu.seatter.spring5recipeapp.repositories.RecipeRepository;
import eu.seatter.spring5recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by jas on 29/10/2018
 */
@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public DataLoader(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes() {

        List<Recipe> recipes = new ArrayList<>(2);

        Optional<UnitOfMeasure> uomTeaspoon = unitOfMeasureRepository.findByDescription("Teaspoon");
        if(!uomTeaspoon.isPresent()) {
            throw new RuntimeException("Expected UOM not found 'Teaspoon'");
        }
        Optional<UnitOfMeasure> uomTablespoon = unitOfMeasureRepository.findByDescription("Tablespoon");
        if(!uomTablespoon.isPresent()) {
            throw new RuntimeException("Expected UOM not found 'Tablespoon'");
        }
        Optional<UnitOfMeasure> uomCup = unitOfMeasureRepository.findByDescription("Cup");
        if(!uomCup.isPresent()) {
            throw new RuntimeException("Expected UOM not found 'Cup'");
        }
        Optional<UnitOfMeasure> uomPinch = unitOfMeasureRepository.findByDescription("Pinch");
        if(!uomPinch.isPresent()) {
            throw new RuntimeException("Expected UOM not found 'Pinch'");
        }
        Optional<UnitOfMeasure> uomPound = unitOfMeasureRepository.findByDescription("Pound");
        if(!uomPound.isPresent()) {
            throw new RuntimeException("Expected UOM not found 'Pound'");
        }
        Optional<UnitOfMeasure> uomOunce = unitOfMeasureRepository.findByDescription("Ounce");
        if(!uomOunce.isPresent()) {
            throw new RuntimeException("Expected UOM not found 'Ounce'");
        }
        Optional<UnitOfMeasure> uomDash = unitOfMeasureRepository.findByDescription("Dash");
        if(!uomDash.isPresent()) {
            throw new RuntimeException("Expected UOM not found 'Dash'");
        }
        Optional<UnitOfMeasure> uomEach = unitOfMeasureRepository.findByDescription("Each");
        if(!uomEach.isPresent()) {
            throw new RuntimeException("Expected UOM not found 'Each'");
        }
        Optional<UnitOfMeasure> uomPint = unitOfMeasureRepository.findByDescription("Pint");
        if(!uomPint.isPresent()) {
            throw new RuntimeException("Expected UOM not found 'Pint'");
        }

        UnitOfMeasure teaspoonUom = uomTeaspoon.get();
        UnitOfMeasure tablespoonUom = uomTablespoon.get();
        UnitOfMeasure cupUom = uomCup.get();
        UnitOfMeasure pinchUom = uomPinch.get();
        UnitOfMeasure poundUom = uomPound.get();
        UnitOfMeasure ounceUom = uomOunce.get();
        UnitOfMeasure dashUom = uomDash.get();
        UnitOfMeasure eachUom = uomEach.get();
        UnitOfMeasure pintUom = uomPint.get();

        Optional<Category> categoryOptionalAmerican = categoryRepository.findByDescription("American");
        if(!categoryOptionalAmerican.isPresent()) {
            throw new RuntimeException("Expected Category not found 'American'");
        }
        Optional<Category> categoryOptionalMexican = categoryRepository.findByDescription("Mexican");
        if(!categoryOptionalMexican.isPresent()) {
            throw new RuntimeException("Expected Category not found 'Mexican'");
        }

        Category americanCategory = categoryOptionalAmerican.get();
        Category mexicanCategory = categoryOptionalMexican.get();


        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("How to Make Perfect Guacamole");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setServings(4);

        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.getCategories().add(americanCategory);
        guacRecipe.getCategories().add(mexicanCategory);
        guacRecipe.setSource("Simply Recipes");
        guacRecipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");

        guacRecipe.setNote(new Note("Be careful handling chiles if using. Wash your hands thoroughly after handling and do not touch your eyes or the area near your eyes with your hands for several hours."));

        // Add directions
        guacRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "\n" +
                "\n" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "\n" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "\n" +
                "Variations\n" +
                "\n" +
                "For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries (see our Strawberry Guacamole).\n" +
                "\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "For a deviled egg version with guacamole, try our Guacamole Deviled Eggs!");


        guacRecipe.addIngredient(new Ingredient(new BigDecimal(2), eachUom,"ripe avocados",guacRecipe));
        guacRecipe.addIngredient(new Ingredient(new BigDecimal(0.5), teaspoonUom,"Kosher salt",guacRecipe));
        guacRecipe.addIngredient(new Ingredient(new BigDecimal(1),teaspoonUom,"of fresh lime juice or lemon juice",guacRecipe));
        guacRecipe.addIngredient(new Ingredient(new BigDecimal(2), tablespoonUom,"of minced red onion or thinly sliced green onion",guacRecipe));
        guacRecipe.addIngredient(new Ingredient(new BigDecimal(2), eachUom,"serrano chiles, stems and seeds removed, minced",guacRecipe));
        guacRecipe.addIngredient(new Ingredient(new BigDecimal(2), tablespoonUom,"cilantro (leaves and tender stems), finely chopped",guacRecipe));
        guacRecipe.addIngredient(new Ingredient(new BigDecimal(1),dashUom,"of freshly grated black pepper",guacRecipe));
        guacRecipe.addIngredient(new Ingredient(new BigDecimal(0.5), eachUom,"ripe tomato, seeds and pulp removed, chopped",guacRecipe));
        
        recipes.add(guacRecipe);

        ///////////////////////////////////////////////////////////////////////////////

        Recipe tacoRecipe = new Recipe();
        tacoRecipe.setDescription("Spicy Grilled Chicken Tacos");
        tacoRecipe.setPrepTime(20);
        tacoRecipe.setCookTime(15);
        tacoRecipe.setServings(6);

        tacoRecipe.setDifficulty(Difficulty.MODERATE);
        tacoRecipe.getCategories().add(americanCategory);
        tacoRecipe.getCategories().add(mexicanCategory);
        tacoRecipe.setSource("Simply Recipes");
        tacoRecipe.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");

        tacoRecipe.setNote(new Note("Look for ancho chile powder with the Mexican ingredients at your grocery store, on buy it online. (If you can't find ancho chili powder, you replace the ancho chili, the oregano, and the cumin with 2 1/2 tablespoons regular chili powder, though the flavor won't be quite the same.)"));

        // Add directions
        tacoRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "Spicy Grilled Chicken Tacos\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");


        tacoRecipe.addIngredient(new Ingredient(new BigDecimal(2), tablespoonUom,"ancho chili powder",tacoRecipe));
        tacoRecipe.addIngredient(new Ingredient(new BigDecimal(1), teaspoonUom,"dried oregano",tacoRecipe));
        tacoRecipe.addIngredient(new Ingredient(new BigDecimal(1),teaspoonUom,"dried cumin",tacoRecipe));
        tacoRecipe.addIngredient(new Ingredient(new BigDecimal(1), teaspoonUom,"sugar",tacoRecipe));
        tacoRecipe.addIngredient(new Ingredient(new BigDecimal(0.5), teaspoonUom,"salt",tacoRecipe));
        tacoRecipe.addIngredient(new Ingredient(new BigDecimal(1), eachUom,"clove garlic, finely chopped",tacoRecipe));
        tacoRecipe.addIngredient(new Ingredient(new BigDecimal(1),tablespoonUom,"finely grated orange zest",tacoRecipe));
        tacoRecipe.addIngredient(new Ingredient(new BigDecimal(3), tablespoonUom,"fresh-squeezed orange juice",tacoRecipe));
        tacoRecipe.addIngredient(new Ingredient(new BigDecimal(2), tablespoonUom,"olive oil",tacoRecipe));
        tacoRecipe.addIngredient(new Ingredient(new BigDecimal(1.25), poundUom,"skinless, boneless chicken thighs (1 1/4 pounds)",tacoRecipe));

        tacoRecipe.addIngredient(new Ingredient(new BigDecimal(8), eachUom,"small corn tortillas",tacoRecipe));
        tacoRecipe.addIngredient(new Ingredient(new BigDecimal(3), ounceUom,"packed baby arugula",tacoRecipe));
        tacoRecipe.addIngredient(new Ingredient(new BigDecimal(2), eachUom,"medium ripe avocados, sliced",tacoRecipe));
        tacoRecipe.addIngredient(new Ingredient(new BigDecimal(4), eachUom,"radishes, thinly sliced",tacoRecipe));
        tacoRecipe.addIngredient(new Ingredient(new BigDecimal(0.5), pintUom,"cherry tomatoes, halved",tacoRecipe));
        tacoRecipe.addIngredient(new Ingredient(new BigDecimal(0.25), eachUom,"red onion, thinly sliced",tacoRecipe));
        tacoRecipe.addIngredient(new Ingredient(new BigDecimal(1), cupUom,"Roughly chopped cilantro",tacoRecipe));
        tacoRecipe.addIngredient(new Ingredient(new BigDecimal(0.5), cupUom,"sour cream thinned",tacoRecipe));
        tacoRecipe.addIngredient(new Ingredient(new BigDecimal(0.25), cupUom,"milk",tacoRecipe));
        tacoRecipe.addIngredient(new Ingredient(new BigDecimal(1), eachUom,"Lime, cut into wedges",tacoRecipe));


        recipes.add(tacoRecipe);
        return recipes;


    }

}
