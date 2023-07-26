package dto;

import lombok.Builder;
import lombok.Value;

/**
 * @author oksanapoliakova on 26.07.2023
 * @projectName FlightMVC
 */

@Value
@Builder
public class UserDto {
    Long id;
    String mail;
}
