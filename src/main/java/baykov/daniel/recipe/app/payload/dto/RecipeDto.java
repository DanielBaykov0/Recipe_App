package baykov.daniel.recipe.app.payload.dto;

import java.util.List;

public record RecipeDto(
    List<String> ingredients,
    String description,
    Integer rating
) {
}
