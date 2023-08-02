package baykov.daniel.recipe.app.payload.mapper;

import baykov.daniel.recipe.app.entity.Recipe;
import baykov.daniel.recipe.app.payload.dto.RecipeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RecipeMapper {

    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);

    RecipeDto entityToDTO(Recipe recipe);

    List<RecipeDto> entityToDTO(Iterable<Recipe> recipes);

    Recipe dtoToEntity(RecipeDto recipeDto);
}
