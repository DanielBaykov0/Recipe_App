package baykov.daniel.recipe.app.service;

import baykov.daniel.recipe.app.model.bindingmodel.IngredientBindingModel;
import baykov.daniel.recipe.app.service.model.IngredientServiceModel;
import baykov.daniel.recipe.app.web.model.IngredientViewModel;

import java.util.List;

public interface IngredientService {

    boolean doesIngredientExist(String name);

    IngredientViewModel findIngredientById(Long id);

    List<IngredientViewModel> findAllIngredients();

    IngredientServiceModel addNewIngredient(IngredientBindingModel ingredientBindingModel);

    void updateIngredient(IngredientServiceModel ingredientServiceModel);

    void deleteIngredientById(Long id);
}
