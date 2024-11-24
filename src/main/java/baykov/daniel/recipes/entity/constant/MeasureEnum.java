package baykov.daniel.recipes.entity.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MeasureEnum {
    CUP, TEASPOON, TABLESPOON;

    @JsonCreator
    public static MeasureEnum fromValue(String value) {
        for (MeasureEnum measure : MeasureEnum.values()) {
            if (measure.name().equalsIgnoreCase(value)) {
                return measure;
            }
        }
        throw new IllegalArgumentException("Invalid MeasureEnum value: " + value);
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }
}
