package baykov.daniel.recipe.app.service;

import baykov.daniel.recipe.app.model.bindingmodel.CategoryBindingModel;
import baykov.daniel.recipe.app.service.model.CategoryServiceModel;
import baykov.daniel.recipe.app.web.model.CategoryViewModel;

import java.util.List;

public interface CategoryService {

    boolean doesCategoryExist(String name);

    CategoryViewModel findCategoryById(Long id);

    List<CategoryViewModel> findAllCategories();

    CategoryServiceModel addNewCategory(CategoryBindingModel categoryBindingModel);

    void updateCategory(CategoryServiceModel categoryServiceModel);

    void deleteCategoryById(Long id);
}
