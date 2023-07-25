package mapper;

/**
 * @author oksanapoliakova on 25.07.2023
 * @projectName FlightMVC
 */
public interface Mapper <F, T> {
    T mapFrom(F object);
}
