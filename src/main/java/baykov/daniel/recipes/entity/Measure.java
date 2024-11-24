package baykov.daniel.recipes.entity;

import baykov.daniel.recipes.entity.constant.MeasureEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "measures")
public class Measure extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private MeasureEnum name;
}
