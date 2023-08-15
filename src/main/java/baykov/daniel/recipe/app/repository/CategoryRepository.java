package baykov.daniel.recipe.app.repository;

import baykov.daniel.recipe.app.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
