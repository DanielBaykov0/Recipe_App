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
@Table(name = "recipe")
public class Recipe extends BaseEntity {

    //    @Column(nullable = false)
    private String name;

    //    @Column(nullable = false)
    private String description;

    //    @Column(nullable = false)
    private String instructions;
}
