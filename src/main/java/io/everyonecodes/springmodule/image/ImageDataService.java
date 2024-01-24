package io.everyonecodes.springmodule.image;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.UUID;

@Service
public class ImageDataService {
    private final ImageDataRepository repository;
    private final String directory;
    private final List<String> possibleExtensions = PossibleImageExtension.get();

    public ImageDataService(ImageDataRepository repository, @Value("${image-data-service.directory}") String directory) {
        this.repository = repository;
        this.directory = directory;
    }

    public ImageData save(MultipartFile file) throws IOException {
        if (!file.isEmpty()) {

            String fileExtension = getExtension(file);
            String fileName = UUID.randomUUID() + fileExtension;
            String filePath = directory + fileName;

            file.transferTo(Path.of(filePath));
            return repository.save(new ImageData(filePath));
        } else {
            throw new RuntimeException("File is empty");
        }
    }

    private String getExtension(MultipartFile file) {
        List<String> splitContent = List.of(file.getContentType().split("/"));

        String fileContent = splitContent.get(0);
        String fileExtension = splitContent.get(1);

        if (fileContent.equalsIgnoreCase("image") && possibleExtensions.contains(fileExtension)) {
            return fileExtension;
        } else {
            throw new RuntimeException("Not supported type of file. Supported types are: " + possibleExtensions);
        }
    }

}
