package baykov.daniel.recipe.app.service.impl;

import baykov.daniel.recipe.app.entity.Recipe;
import baykov.daniel.recipe.app.exception.ResourceNotFoundException;
import baykov.daniel.recipe.app.payload.dto.RecipeDto;
import baykov.daniel.recipe.app.payload.mapper.RecipeMapper;
import baykov.daniel.recipe.app.payload.response.RecipeResponse;
import baykov.daniel.recipe.app.repository.RecipeRepository;
import baykov.daniel.recipe.app.service.RecipeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public RecipeDto createRecipe(RecipeDto recipeDto) {
        Recipe recipe = RecipeMapper.INSTANCE.dtoToEntity(recipeDto);
        return RecipeMapper.INSTANCE.entityToDTO(recipeRepository.save(recipe));
    }

    @Override
    public RecipeDto getRecipeById(Long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe", "id", recipeId));
        return RecipeMapper.INSTANCE.entityToDTO(recipe);
    }

    @Override
    public RecipeResponse getAllRecipes(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Recipe> allRecipes = recipeRepository.findAll(pageable);
        return getRecipeResponse(allRecipes);
    }

    @Override
    public RecipeDto updateRecipeById(RecipeDto recipeDto, Long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe", "id", recipeId));
        recipe.setIngredients(recipeDto.ingredients());
        recipe.setDescription(recipeDto.description());
        recipe.setRating(recipeDto.rating());
        return RecipeMapper.INSTANCE.entityToDTO(recipeRepository.save(recipe));
    }

    @Override
    public void deleteRecipeId(Long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe", "id", recipeId));
        recipeRepository.delete(recipe);
    }

    private RecipeResponse getRecipeResponse(Page<Recipe> allRecipes) {
        List<RecipeDto> content = RecipeMapper.INSTANCE.entityToDTO(allRecipes.getContent());
        RecipeResponse response = new RecipeResponse(content);
        response.setPageNo(allRecipes.getNumber());
        response.setPageSize(allRecipes.getSize());
        response.setTotalPages(allRecipes.getTotalPages());
        response.setTotalElements(allRecipes.getTotalElements());
        response.setLast(allRecipes.isLast());
        return response;
    }
}
