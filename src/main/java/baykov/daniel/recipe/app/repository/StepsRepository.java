package baykov.daniel.recipe.app.repository;

import baykov.daniel.recipe.app.model.entity.Steps;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StepsRepository extends JpaRepository<Steps, Long> {
}
