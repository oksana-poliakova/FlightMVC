package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

/**
 * @author oksanapoliakova on 25.07.2023
 * @projectName FlightMVC
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Integer id;
    private String name;
    private String image;
    private LocalDate birthday;
    private String email;
    private String password;
    private Role role;
    private Gender gender;
}
