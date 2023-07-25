package entity;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author oksanapoliakova on 25.07.2023
 * @projectName FlightMVC
 */
public enum Gender {
    MALE,
    FEMALE;

    public static Optional<Gender> find(String gender) {
        return Arrays.stream(values())
                .filter(it -> it.name().equals(gender))
                .findFirst();
    }
}
