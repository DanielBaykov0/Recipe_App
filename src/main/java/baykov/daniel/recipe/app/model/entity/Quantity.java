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
@Table(name = "quantity")
public class Quantity extends BaseEntity {

//    @Column(nullable = false)
    private Recipe recipe;

//    @Column(nullable = false)
    private Ingredient ingredient;

//    @Column(nullable = false)
    private Measure measure;

//    @Column(nullable = false)
    private double ingredientQuantity;
}
