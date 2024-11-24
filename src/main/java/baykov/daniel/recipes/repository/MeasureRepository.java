package baykov.daniel.recipes.repository;

import baykov.daniel.recipes.entity.Measure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MeasureRepository extends JpaRepository<Measure, Long> {

    Optional<Measure> findByName(String name);
}
