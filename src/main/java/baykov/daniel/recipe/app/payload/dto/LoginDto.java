package baykov.daniel.recipe.app.payload.dto;

import jakarta.validation.constraints.NotEmpty;

public record LoginDto(

        @NotEmpty(message = "Username or email should not be null or empty")
        String usernameOrEmail,

        @NotEmpty(message = "Password should not be null or empty")
        String password
) {
}
