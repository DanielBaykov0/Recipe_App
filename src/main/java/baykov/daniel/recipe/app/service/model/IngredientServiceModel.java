package baykov.daniel.recipe.app.service.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientServiceModel {

    private Long id;

    @NotEmpty
    private String name;
}
