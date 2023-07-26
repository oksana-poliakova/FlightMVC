package validator;

/**
 * @author oksanapoliakova on 25.07.2023
 * @projectName FlightMVC
 */
public interface Validator<T> {
    ValidationResult isValid(T object);
}
