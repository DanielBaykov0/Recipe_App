package baykov.daniel.recipe.app.web.controller;

import baykov.daniel.recipe.app.model.bindingmodel.IngredientBindingModel;
import baykov.daniel.recipe.app.service.IngredientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    public IngredientBindingModel ingredientBindingModel() {
        return new IngredientBindingModel();
    }

    @GetMapping("ingredients/all")
    public String allIngredients(Model model) {
        model.addAttribute("allIngredients", ingredientService.findAllIngredients());
        return "ingredients/all-ingredients";
    }

    @GetMapping("/admin/add")
    public String addIngredientPage(Model model) {
        if (!model.containsAttribute("ingredientAlreadyAdded")) {
            model.addAttribute("ingredientAlreadyAdded", false);
        }

        return "ingredients/add-ingredient";
    }
}
