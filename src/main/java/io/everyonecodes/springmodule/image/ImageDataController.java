package io.everyonecodes.springmodule.image;

import io.everyonecodes.springmodule.snapshot.SnapshotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ImageDataController {
    private ImageDataService service;
    private SnapshotService SnapshotService;

    public ImageDataController(ImageDataService service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public ResponseEntity<ImageData> uploadImageToFileSystem(@RequestParam("image") MultipartFile file) throws IOException {
        ImageData imageData = service.save(file);
        return new ResponseEntity<>(imageData, HttpStatus.CREATED);
    }
}
