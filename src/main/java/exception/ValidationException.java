package exception;

import validator.Error;
import lombok.Getter;

import java.util.List;

/**
 * @author oksanapoliakova on 25.07.2023
 * @projectName FlightMVC
 */
public class ValidationException extends RuntimeException {
    @Getter
    private final List<Error> errors;

    public ValidationException(List<Error> errors) {
        this.errors = errors;
    }
}
