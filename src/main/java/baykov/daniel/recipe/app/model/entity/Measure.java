package baykov.daniel.recipe.app.model.entity;

import baykov.daniel.recipe.app.model.constant.MeasureEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "measure")
public class Measure extends BaseEntity {

    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
    private MeasureEnum name;
}
