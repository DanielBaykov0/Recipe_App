package baykov.daniel.recipe.app.repository;

import baykov.daniel.recipe.app.model.entity.Quantity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuantityRepository extends JpaRepository<Quantity, Long> {
}
