package baykov.daniel.recipes.repository;

import baykov.daniel.recipes.entity.Quantity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuantityRepository extends JpaRepository<Quantity, Long> {
}
