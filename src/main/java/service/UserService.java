package service;

import dao.UserDao;
import dto.CreateUserDto;
import dto.validator.CreateUserValidator;
import exception.ValidationException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import mapper.CreateUserMapper;

import java.sql.SQLException;

/**
 * @author oksanapoliakova on 25.07.2023
 * @projectName FlightMVC
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {
    private static final UserService INSTANCE = new UserService();
    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();


    public Integer create(CreateUserDto userDto) throws SQLException {
        var validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        var userEntity = createUserMapper.mapFrom(userDto);
        userDao.save(userEntity);
        return userEntity.getId();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
