package baykov.daniel.recipe.app.service;

import baykov.daniel.recipe.app.payload.dto.RecipeDto;
import baykov.daniel.recipe.app.payload.response.RecipeResponse;

public interface RecipeService {

    RecipeDto createRecipe(RecipeDto recipeDto);

    RecipeDto getRecipeById(Long recipeId);

    RecipeResponse getAllRecipes(int pageNo, int pageSize, String sortBy, String sortDir);

    RecipeDto updateRecipeById(RecipeDto recipeDto, Long recipeId);

    void deleteRecipeId(Long recipeId);
}
