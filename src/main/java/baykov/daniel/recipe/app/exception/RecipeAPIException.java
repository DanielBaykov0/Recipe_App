package baykov.daniel.recipe.app.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class RecipeAPIException extends RuntimeException {

    private HttpStatus status;
    private String message;

    public RecipeAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
