package baykov.daniel.recipe.app.model.bindingmodel;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientBindingModel {

    @NotEmpty
    private String name;
}
