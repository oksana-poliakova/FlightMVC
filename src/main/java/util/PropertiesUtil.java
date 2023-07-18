package util;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Oksana Poliakova on 18.07.2023
 * @projectName FlightMVC
 */

/**
 * This class helps in loading and accessing properties from an application.properties file.
 */

public final class PropertiesUtil {
    // Properties object to store key-value pairs
    private static final Properties PROPERTIES = new Properties();

    static {
        // Load properties from the file during class initialization
        loadProperties();
    }

    private static void loadProperties() {
        try (var inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            // Load properties from the input stream
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private PropertiesUtil() {
    }

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }
}
