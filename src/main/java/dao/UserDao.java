package dao;

import entity.User;
import lombok.SneakyThrows;
import util.ConnectionManager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * @author oksanapoliakova on 25.07.2023
 * @projectName FlightMVC
 */
public class UserDao implements Dao<Integer, User> {

    public static final UserDao INSTANCE = new UserDao();

    private static final String SAVE_SQL =
            "INSERT INTO users (name, birthday, email, password, role, gender) " +
            "VALUES (?, ?, ?, ?, ?, ?)";

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    @SneakyThrows
    public User save(User entity) {
        try (var connection = ConnectionManager.get();
        var preparedStatement = connection.prepareStatement(SAVE_SQL)) {
            preparedStatement.setObject(1, entity.getName());
            preparedStatement.setObject(2, entity.getBirthday());
            preparedStatement.setObject(3, entity.getEmail());
            preparedStatement.setObject(4, entity.getPassword());
            preparedStatement.setObject(5, entity.getRole().name());
            preparedStatement.setObject(6, entity.getGender().name());

            preparedStatement.executeUpdate();

            var generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();

            entity.setId(generatedKeys.getObject("id", Integer.class));
        } catch (SQLException exception) {
            throw exception;
        }
        return entity;
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }
}
