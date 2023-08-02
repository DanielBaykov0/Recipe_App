package baykov.daniel.recipe.app.payload.dto;

public record RecipeDto(

        Long id,
        String name,
        String description,
        String instructions
) {
}
