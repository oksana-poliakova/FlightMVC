package dto;

import lombok.Builder;
import lombok.Value;

/**
 * @author oksanapoliakova on 25.07.2023
 * @projectName FlightMVC
 */

@Value
@Builder
public class CreateUserDto {
    String name;
    String birthday;
    String email;
    String password;
    String role;
    String gender;
}
