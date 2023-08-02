package baykov.daniel.recipe.app.service;

import baykov.daniel.recipe.app.payload.dto.LoginDto;
import baykov.daniel.recipe.app.payload.dto.RegisterDto;

public interface AuthenticationService {

    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
