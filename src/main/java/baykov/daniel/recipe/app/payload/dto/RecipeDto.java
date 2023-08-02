package baykov.daniel.recipe.app.payload.dto;

import java.util.List;

public record RecipeDto(

        Long id,
        List<String> ingredients,
        String description,
        Integer rating
) {
}
