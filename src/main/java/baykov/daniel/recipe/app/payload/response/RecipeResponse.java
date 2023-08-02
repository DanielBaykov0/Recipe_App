package baykov.daniel.recipe.app.payload.response;

import baykov.daniel.recipe.app.payload.dto.RecipeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipeResponse extends GeneralResponse {

    private List<RecipeDto> content;
}
