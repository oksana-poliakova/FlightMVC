package service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import util.PropertiesUtil;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

/**
 * @author oksanapoliakova on 25.07.2023
 * @projectName FlightMVC
 */

/**
 * Service for working with images.
 * This class provides functionality for uploading and retrieving images.
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ImageService {
    private static final ImageService INSTANCE = new ImageService();

    // The base path for storing images, obtained from the configuration file.
    private final String basePath = PropertiesUtil.get("image.base.url");

    /**
     * Method for uploading an image at the specified path.
     * @param imagePath    The path for saving the image.
     * @param imageContent The input stream containing the image data.
     * @throws IOException Thrown in case of input/output errors while saving the image.
     */

    @SneakyThrows
    public void upload(String imagePath, InputStream imageContent) {
        var imageFullPath = Path.of(basePath, imagePath);
        try (imageContent) {
            // Create directories for the image path if they don't exist.
            Files.createDirectories(imageFullPath.getParent());
            // Write the image data to the specified path.
            Files.write(imageFullPath, imageContent.readAllBytes(), CREATE, TRUNCATE_EXISTING);
        } catch (IOException exception) {
            throw exception;
        }
    }

    /**
     * Method for retrieving an image at the specified path.
     * @param imagePath The path to the image.
     * @return Returns an Optional containing the input stream of the image data if the image is found.
     */

    @SneakyThrows
    public Optional<InputStream> get(String imagePath) {
        var imageFullPath = Path.of(basePath, imagePath);

        return Files.exists(imageFullPath)
                ? Optional.of(Files.newInputStream(imageFullPath))
                : Optional.empty();
    }


    public static ImageService getInstance() {
        return INSTANCE;
    }
}
