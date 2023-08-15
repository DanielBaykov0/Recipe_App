package baykov.daniel.recipe.app.repository;

import baykov.daniel.recipe.app.model.entity.Measure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasureRepository extends JpaRepository<Measure, Long> {
}
