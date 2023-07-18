package dao;

import java.util.List;
import java.util.Optional;

/**
 * @author Oksana Poliakova on 18.07.2023
 * @projectName FlightMVC
 */
public interface Dao <K, T> {
    // Retrieves all objects of type T from a data source
    List<T> findAll();
    // Finds an object of type T based on its ID
    Optional<T> findById(K id);
    // Delete
    boolean delete(K id);
    // Update
    void update(T entity);
    // Save
    T save(T entity);
}
