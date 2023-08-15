package baykov.daniel.recipe.app.repository;

import baykov.daniel.recipe.app.model.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
