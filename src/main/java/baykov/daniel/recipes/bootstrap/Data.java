package baykov.daniel.recipes.bootstrap;

import baykov.daniel.recipes.entity.constant.CategoryEnum;
import baykov.daniel.recipes.entity.constant.MeasureEnum;
import baykov.daniel.recipes.entity.Category;
import baykov.daniel.recipes.entity.Ingredient;
import baykov.daniel.recipes.entity.Measure;
import baykov.daniel.recipes.repository.CategoryRepository;
import baykov.daniel.recipes.repository.IngredientRepository;
import baykov.daniel.recipes.repository.MeasureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Data implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final IngredientRepository ingredientRepository;
    private final MeasureRepository measureRepository;

    @Override
    public void run(String... args) {

        if (categoryRepository.count() == 0) {
            loadCategoryData();
        }

        if (ingredientRepository.count() == 0) {
            loadIngredientData();
        }

        if (measureRepository.count() == 0) {
            loadMeasureData();
        }
    }

    private void loadCategoryData() {
        for (CategoryEnum categoryEnum : CategoryEnum.values()) {
            categoryRepository.save(
                    Category.builder()
                            .name(categoryEnum)
                            .build()
            );
        }
    }

    private void loadIngredientData() {
        List<String> ingredientNames = List.of(
                "Onion", "Cucumber", "Mushroom", "Tomato",
                "Spinach", "Lettuce", "Green Peas", "Pumpkin"
        );

        ingredientNames.forEach(name -> {
            Ingredient ingredient = Ingredient.builder()
                    .name(name)
                    .build();
            ingredientRepository.save(ingredient);
        });
    }

    private void loadMeasureData() {
        for (MeasureEnum measureEnum : MeasureEnum.values()) {
            measureRepository.save(
                    Measure.builder()
                            .name(measureEnum)
                            .build()
            );
        }
    }
}
