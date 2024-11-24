//package baykov.daniel.recipes.service;
//
//import baykov.daniel.recipes.entity.Ingredient;
//import baykov.daniel.recipes.model.bindingmodel.IngredientBindingModel;
//import baykov.daniel.recipes.service.model.IngredientServiceModel;
//import baykov.daniel.recipes.web.model.IngredientViewModel;
//import baykov.daniel.recipes.repository.IngredientRepository;
//import baykov.daniel.recipes.exception.ResourceNotFoundException;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class IngredientServiceImpl implements IngredientService {
//
//    private final IngredientRepository ingredientRepository;
//    private final ModelMapper modelMapper;
//
//    public IngredientServiceImpl(IngredientRepository ingredientRepository, ModelMapper modelMapper) {
//        this.ingredientRepository = ingredientRepository;
//        this.modelMapper = modelMapper;
//    }
//
//    @Override
//    public boolean doesIngredientExist(String name) {
//        return ingredientRepository.findByName(name).isPresent();
//    }
//
//    @Override
//    public IngredientViewModel findIngredientById(Long id) {
//        return ingredientRepository.findById(id)
//                .map(ingredient -> {
//                    IngredientViewModel ingredientViewModel = new IngredientViewModel();
//                    modelMapper.map(ingredient, ingredientViewModel);
//                    ingredientViewModel.setName(ingredient.getName());
//                    return ingredientViewModel;
//                })
//                .orElseThrow(() -> new ResourceNotFoundException(id));
//    }
//
//    @Override
//    public List<IngredientViewModel> findAllIngredients() {
//        return ingredientRepository
//                .findAll()
//                .stream()
//                .map(ingredient -> {
//                    IngredientViewModel ingredientViewModel = modelMapper.map(ingredient, IngredientViewModel.class);
//                    ingredientViewModel.setName(ingredient.getName());
//                    return ingredientViewModel;
//                })
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public IngredientServiceModel addNewIngredient(IngredientBindingModel ingredientBindingModel) {
//
//        Ingredient ingredient = modelMapper.map(ingredientBindingModel, Ingredient.class);
//        ingredient.setName(ingredientBindingModel.getName());
//
//        Ingredient savedIngredient = ingredientRepository.save(ingredient);
//        return modelMapper.map(savedIngredient, IngredientServiceModel.class);
//    }
//
//    @Override
//    public void updateIngredient(IngredientServiceModel ingredientServiceModel) {
//        Ingredient ingredient = ingredientRepository.findById(ingredientServiceModel.getId())
//                .orElseThrow(() -> new ResourceNotFoundException(ingredientServiceModel.getId()));
//
//        ingredient.setName(ingredientServiceModel.getName());
//        ingredientRepository.save(ingredient);
//    }
//
//    @Override
//    public void deleteIngredientById(Long id) {
//        ingredientRepository.deleteById(id);
//    }
//}
