package entity;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author oksanapoliakova on 25.07.2023
 * @projectName FlightMVC
 */
public enum Role {
    USER,
    ADMIN;

    public static Optional<Role> find(String role) {
        return Arrays.stream(values())
                .filter(it -> it.name().equals(role))
                .findFirst();
    }
}

