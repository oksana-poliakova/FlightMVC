package mapper;

import dto.UserDto;
import entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author oksanapoliakova on 26.07.2023
 * @projectName FlightMVC
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper implements Mapper <User, UserDto> {
    private static final UserMapper INSTANCE = new UserMapper();

    @Override
    public UserDto mapFrom(User object) {
        return UserDto.builder()
                .id(object.getId())
                .name(object.getName())
                .image(object.getImage())
                .birthday(object.getBirthday())
                .email(object.getEmail())
                .role(object.getRole())
                .gender(object.getGender())
                .build();
    }

    public static UserMapper getInstance() {
        return INSTANCE;
    }
}
