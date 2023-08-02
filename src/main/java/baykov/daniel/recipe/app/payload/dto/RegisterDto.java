package baykov.daniel.recipe.app.payload.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record RegisterDto(

        @NotEmpty(message = "Name should not be null or empty")
        @Size(min = 2, message = "Name should have at least 2 characters")
        String name,

        @NotEmpty(message = "Username should not be null or empty")
        @Size(min = 6, message = "Username should have at least 6 characters")
        String username,

        @NotEmpty(message = "Password should not be null or empty")
        @Size(min = 8, max = 20, message = "Password should be between 8 and 20 characters")
        String password,

        @NotEmpty(message = "Email should not be null or empty")
        @Email
        String email,

        Long age,

        @NotNull(message = "Birthday should not be empty")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate dateOfBirth,

        @NotEmpty(message = "Gender should not be null or empty")
        String gender,

        @NotEmpty(message = "Address should not be null or empty")
        @Size(min = 6, message = "Address should have at least 6 characters")
        String address,

        @NotEmpty(message = "City should not be null or empty")
        @Size(min = 4, message = "City should have at least 4 characters")
        String city,

        @NotEmpty(message = "Country should not be null or empty")
        @Size(min = 2, message = "Country should have at least 4 characters")
        String country
) {
}
