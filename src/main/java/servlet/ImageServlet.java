package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import service.ImageService;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author oksanapoliakova on 26.07.2023
 * @projectName FlightMVC
 */

@WebServlet("/images/*")
public class ImageServlet extends HttpServlet {
    private final ImageService imageService = ImageService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get the request URI to extract the image path.
        var requestUri = req.getRequestURI();
        // Extract the image path by removing the "/images" part from the request URI.
        var imagePath = requestUri.replace("/images", "");

        // Try to retrieve the image from the ImageService based on the extracted image path.
        imageService.get(imagePath)
                .ifPresentOrElse(image -> {
                    // If the image exists, set the content type to "application/octet-stream".
                    resp.setContentType("application/octet-stream");
                    // Write the image data to the response using the helper method writeImage.
                    writeImage(image, resp);
                    // If the image doesn't exist, set the response status to 404 (Not Found).
                }, () -> resp.setStatus(404));
    }

    // Helper method to write the image data to the response.
    @SneakyThrows
    private void writeImage(InputStream image, HttpServletResponse resp) {
        try (image; var outputStream = resp.getOutputStream()) {
            // Read the image data byte by byte from the InputStream and write it to the response OutputStream.
            int currentByte;
            while ((currentByte = image.read()) != -1) {
                outputStream.write(currentByte);
            }
        }
    }
}
