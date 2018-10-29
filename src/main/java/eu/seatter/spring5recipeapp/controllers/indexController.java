package eu.seatter.spring5recipeapp.controllers;

import eu.seatter.spring5recipeapp.services.RecipeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jas on 11/10/2018
 */
@Controller
public class indexController {

    private final RecipeServiceImpl recipeService;

    public indexController(RecipeServiceImpl recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model) {
        model.addAttribute("recipes",recipeService.getRecipes());
        return "index";
    }
}
