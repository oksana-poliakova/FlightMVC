package dto.validator;

import lombok.Value;

/**
 * @author oksanapoliakova on 25.07.2023
 * @projectName FlightMVC
 */

@Value(staticConstructor = "of")
public class Error {
    String code;
    String message;
}
