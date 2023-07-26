package dto;

import entity.Gender;
import entity.Role;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

/**
 * @author oksanapoliakova on 26.07.2023
 * @projectName FlightMVC
 */

@Value
@Builder
public class UserDto {
    Integer id;
    String name;
    LocalDate birthday;
    String email;
    String image;
    Role role;
    Gender gender;
}
