package dto.validator;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author oksanapoliakova on 25.07.2023
 * @projectName FlightMVC
 */
public class ValidationResult {

    @Getter
    private final List<Error> errors = new ArrayList<>();

    public void add(Error error) {
        this.errors.add(error);
    }

    public boolean isValid() {
        return errors.isEmpty();
    }
}
