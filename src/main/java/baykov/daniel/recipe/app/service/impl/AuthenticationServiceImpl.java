package baykov.daniel.recipe.app.service.impl;

import baykov.daniel.recipe.app.entity.Role;
import baykov.daniel.recipe.app.entity.User;
import baykov.daniel.recipe.app.exception.RecipeAPIException;
import baykov.daniel.recipe.app.payload.dto.LoginDto;
import baykov.daniel.recipe.app.payload.dto.RegisterDto;
import baykov.daniel.recipe.app.repository.RoleRepository;
import baykov.daniel.recipe.app.repository.UserRepository;
import baykov.daniel.recipe.app.security.JwtTokenProvider;
import baykov.daniel.recipe.app.service.AuthenticationService;
import baykov.daniel.recipe.app.utils.Messages;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String login(LoginDto loginDto) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.usernameOrEmail(), loginDto.password()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtTokenProvider.generateToken(authentication);
    }

    @Override
    public String register(RegisterDto registerDto) {
        if (userRepository.existsByUsername(registerDto.username())) {
            throw new RecipeAPIException(HttpStatus.BAD_REQUEST, Messages.USERNAME_EXISTS);
        }

        if (userRepository.existsByEmail(registerDto.email())) {
            throw new RecipeAPIException(HttpStatus.BAD_REQUEST, Messages.EMAIL_EXISTS);
        }

        User user = new User();
        user.setName(registerDto.name());
        user.setUsername(registerDto.username());
        user.setPassword(passwordEncoder.encode(registerDto.password()));
        user.setCity(registerDto.city());
        int userAge = LocalDate.now().getYear() - registerDto.dateOfBirth().getYear();
        user.setAge(userAge);
        user.setAddress(registerDto.address());
        user.setCountry(registerDto.country());
        user.setGender(registerDto.gender());
        user.setEmail(registerDto.email());
        user.setDateOfBirth(registerDto.dateOfBirth());

        Set<Role> roles = new HashSet<>();
        Optional<Role> userRole = roleRepository.findByName("ROLE_USER");
        Role role = new Role();
        if (userRole.isPresent()) {
            role = userRole.get();
        }
        roles.add(role);
        user.setRoles(roles);

        userRepository.save(user);
        return Messages.USER_SUCCESSFULLY_REGISTERED;
    }
}
