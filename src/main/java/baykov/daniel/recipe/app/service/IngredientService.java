package baykov.daniel.recipe.app.service;

import baykov.daniel.recipe.app.model.model.bindingmodel.IngredientBindingModel;
import baykov.daniel.recipe.app.model.model.servicemodel.IngredientServiceModel;
import baykov.daniel.recipe.app.model.model.viewmodel.IngredientViewModel;

import java.util.List;

public interface IngredientService {

    boolean doesIngredientExist(String name);

    IngredientViewModel findIngredientById(Long id);

    List<IngredientViewModel> findAllIngredients();

    IngredientServiceModel addNewIngredient(IngredientBindingModel ingredientBindingModel);

    void updateIngredient(IngredientServiceModel ingredientServiceModel);

    void deleteIngredientById(Long id);
}
