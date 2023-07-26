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

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ImageService {
    private static final ImageService INSTANCE = new ImageService();

    private final String basePath = PropertiesUtil.get("image.base.url");

    @SneakyThrows
    public void upload(String imagePath, InputStream imageContent) {
        var imageFullPath = Path.of(basePath, imagePath);
        try (imageContent) {
            Files.createDirectories(imageFullPath.getParent());
            Files.write(imageFullPath, imageContent.readAllBytes(), CREATE, TRUNCATE_EXISTING);
        } catch (IOException exception) {
            throw exception;
        }
    }

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
