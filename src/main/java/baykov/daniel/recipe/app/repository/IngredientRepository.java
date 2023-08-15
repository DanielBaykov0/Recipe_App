package baykov.daniel.recipe.app.repository;

import baykov.daniel.recipe.app.model.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
