package baykov.daniel.recipe.app.bootstrap;

import baykov.daniel.recipe.app.entity.Recipe;
import baykov.daniel.recipe.app.entity.Role;
import baykov.daniel.recipe.app.repository.RecipeRepository;
import baykov.daniel.recipe.app.repository.RoleRepository;
import baykov.daniel.recipe.app.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final RecipeRepository recipeRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public DataLoader(RecipeRepository recipeRepository, RoleRepository roleRepository, UserRepository userRepository) {
        this.recipeRepository = recipeRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = roleRepository.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        roleRepository.save(roleAdmin);

        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");
        roleRepository.save(roleUser);

//        User daniel = new User();
//        daniel.setName("Daniel");
//        daniel.setUsername("daniel");
//        daniel.setAge(27);
//        daniel.setCity("Sofia");
//        daniel.setCountry("Bulgaria");
//        daniel.setAddress("123 Street");
//        daniel.setEmail("daniel@gmail.com");
//        daniel.setGender("male");
//        daniel.setPassword("$2a$12$yo61nW7pEYK7jtBSkzt1cO7wtj5XO8LNFZ1lDqfMk5SfLNb9NFF1O");
//        Set<Role> roles = new HashSet<>();
//        roles.add(roleUser);
//        daniel.setRoles(roles);
//        daniel.setDateOfBirth(LocalDate.of(1996, 2, 5));
//        userRepository.save(daniel);


        Recipe recipe = new Recipe();
        recipe.setName("Salad with cheese, tomatoes and basil");
        recipe.setDescription("Salad with cheese, tomatoes and basil");
        recipe.setInstructions("Instructions for salad");
        recipeRepository.save(recipe);
    }
}
