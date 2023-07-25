package mapper;

import dto.CreateUserDto;
import entity.Gender;
import entity.Role;
import entity.User;
import util.LocalDateFormatter;

/**
 * @author oksanapoliakova on 25.07.2023
 * @projectName FlightMVC
 */
public class CreateUserMapper implements Mapper<CreateUserDto, User> {

    public static final String IMAGE_FOLDER = "users/";
    public static final CreateUserMapper INSTANCE = new CreateUserMapper();
    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                .name(object.getName())
                .email(object.getEmail())
                .birthday(LocalDateFormatter.format(object.getBirthday()))
                .password(object.getPassword())
                .image(IMAGE_FOLDER + object.getImage().getSubmittedFileName())
                .gender(Gender.valueOf(object.getGender()))
                .role(Role.valueOf(object.getRole()))
                .build();
    }

    public static CreateUserMapper getInstance() {
        return INSTANCE;
    }
}
