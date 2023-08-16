package baykov.daniel.recipe.app.service.impl;

import baykov.daniel.recipe.app.model.bindingmodel.CategoryBindingModel;
import baykov.daniel.recipe.app.model.entity.Category;
import baykov.daniel.recipe.app.repository.CategoryRepository;
import baykov.daniel.recipe.app.service.CategoryService;
import baykov.daniel.recipe.app.service.model.CategoryServiceModel;
import baykov.daniel.recipe.app.web.exception.ResourceNotFoundException;
import baykov.daniel.recipe.app.web.model.CategoryViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean doesCategoryExist(String name) {
        return categoryRepository.findByName(name).isPresent();
    }

    @Override
    public CategoryViewModel findCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(category -> {
                    CategoryViewModel categoryViewModel = new CategoryViewModel();
                    modelMapper.map(category, categoryViewModel);
                    categoryViewModel.setName(category.getName());
                    return categoryViewModel;
                })
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public List<CategoryViewModel> findAllCategories() {
        return categoryRepository
                .findAll()
                .stream()
                .map(category -> {
                    CategoryViewModel categoryViewModel = new CategoryViewModel();
                    categoryViewModel.setId(category.getId());
                    categoryViewModel.setName(category.getName());
                    return categoryViewModel;
                }).collect(Collectors.toList());
    }

    @Override
    public CategoryServiceModel addNewCategory(CategoryBindingModel categoryBindingModel) {
        Category category = modelMapper.map(categoryBindingModel, Category.class);
        category.setName(categoryBindingModel.getName());

        Category savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryServiceModel.class);
    }

    @Override
    public void updateCategory(CategoryServiceModel categoryServiceModel) {
        Category category = categoryRepository.findById(categoryServiceModel.getId())
                .orElseThrow(() -> new ResourceNotFoundException(categoryServiceModel.getId()));

        category.setName(categoryServiceModel.getName());
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
}
