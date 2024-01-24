package io.everyonecodes.springmodule.image;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.everyonecodes.springmodule.snapshot.Snapshot;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ImageData {
    @Id
    @GeneratedValue
    private Long id;

    private String filePath;

    @OneToOne(mappedBy = "imageData")
    @JsonBackReference
    private Snapshot snapshot;

    public ImageData(String filePath) {
        this.filePath = filePath;
    }
}
