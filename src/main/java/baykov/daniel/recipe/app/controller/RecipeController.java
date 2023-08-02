package baykov.daniel.recipe.app.controller;

import baykov.daniel.recipe.app.payload.dto.RecipeDto;
import baykov.daniel.recipe.app.payload.response.RecipeResponse;
import baykov.daniel.recipe.app.service.RecipeService;
import baykov.daniel.recipe.app.utils.AppConstants;
import baykov.daniel.recipe.app.utils.Messages;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public ResponseEntity<RecipeDto> createRecipe(@RequestBody @Valid RecipeDto recipeDto) {
        return new ResponseEntity<>(recipeService.createRecipe(recipeDto), HttpStatus.CREATED);
    }

    @GetMapping("{recipeId}")
    public ResponseEntity<RecipeDto> getRecipeById(@PathVariable Long recipeId) {
        return ResponseEntity.ok(recipeService.getRecipeById(recipeId));
    }

    @GetMapping
    public ResponseEntity<RecipeResponse> getAllRecipes(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return ResponseEntity.ok(recipeService.getAllRecipes(pageNo, pageSize, sortBy, sortDir));
    }

    @PutMapping("{recipeId}")
    public ResponseEntity<RecipeDto> updateRecipeById(@RequestBody @Valid RecipeDto recipeDto, @PathVariable Long recipeId) {
        return ResponseEntity.ok(recipeService.updateRecipeById(recipeDto, recipeId));
    }

    @DeleteMapping("{recipeId}")
    public ResponseEntity<String> deleteRecipeById(@PathVariable Long recipeId) {
        recipeService.deleteRecipeId(recipeId);
        return ResponseEntity.ok(Messages.SUCCESSFULLY_DELETED);
    }

}
