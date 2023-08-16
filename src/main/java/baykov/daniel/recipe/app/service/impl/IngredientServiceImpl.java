package baykov.daniel.recipe.app.service.impl;

import baykov.daniel.recipe.app.model.entity.Ingredient;
import baykov.daniel.recipe.app.model.bindingmodel.IngredientBindingModel;
import baykov.daniel.recipe.app.service.model.IngredientServiceModel;
import baykov.daniel.recipe.app.web.model.IngredientViewModel;
import baykov.daniel.recipe.app.repository.IngredientRepository;
import baykov.daniel.recipe.app.service.IngredientService;
import baykov.daniel.recipe.app.web.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;
    private final ModelMapper modelMapper;

    public IngredientServiceImpl(IngredientRepository ingredientRepository, ModelMapper modelMapper) {
        this.ingredientRepository = ingredientRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean doesIngredientExist(String name) {
        return ingredientRepository.findByName(name).isPresent();
    }

    @Override
    public IngredientViewModel findIngredientById(Long id) {
        return ingredientRepository.findById(id)
                .map(ingredient -> {
                    IngredientViewModel ingredientViewModel = new IngredientViewModel();
                    modelMapper.map(ingredient, ingredientViewModel);
                    ingredientViewModel.setName(ingredient.getName());
                    return ingredientViewModel;
                })
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public List<IngredientViewModel> findAllIngredients() {
        return ingredientRepository
                .findAll()
                .stream()
                .map(ingredient -> {
                    IngredientViewModel ingredientViewModel = modelMapper.map(ingredient, IngredientViewModel.class);
                    ingredientViewModel.setName(ingredient.getName());
                    return ingredientViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public IngredientServiceModel addNewIngredient(IngredientBindingModel ingredientBindingModel) {

        Ingredient ingredient = modelMapper.map(ingredientBindingModel, Ingredient.class);
        ingredient.setName(ingredientBindingModel.getName());

        Ingredient savedIngredient = ingredientRepository.save(ingredient);
        return modelMapper.map(savedIngredient, IngredientServiceModel.class);
    }

    @Override
    public void updateIngredient(IngredientServiceModel ingredientServiceModel) {
        Ingredient ingredient = ingredientRepository.findById(ingredientServiceModel.getId())
                .orElseThrow(() -> new ResourceNotFoundException(ingredientServiceModel.getId()));

        ingredient.setName(ingredientServiceModel.getName());
        ingredientRepository.save(ingredient);
    }

    @Override
    public void deleteIngredientById(Long id) {
        ingredientRepository.deleteById(id);
    }
}
