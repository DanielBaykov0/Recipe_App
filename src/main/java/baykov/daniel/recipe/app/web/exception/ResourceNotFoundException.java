package baykov.daniel.recipe.app.web.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

    private final Long resourceId;

    public ResourceNotFoundException(Long resourceId) {
        super("Cannot find resource with id " + resourceId);
        this.resourceId = resourceId;
    }

    public Long getResourceId() {
        return resourceId;
    }
}
