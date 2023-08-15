package baykov.daniel.recipe.app.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ingredient")
public class Ingredient extends BaseEntity {

    //    @Column(nullable = false)
    private String name;

    public Ingredient(Long id, String name) {
        super(id);
        this.name = name;
    }
}
