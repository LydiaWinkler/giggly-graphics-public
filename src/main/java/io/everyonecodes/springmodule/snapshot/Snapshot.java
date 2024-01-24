package io.everyonecodes.springmodule.snapshot;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.everyonecodes.springmodule.image.ImageData;
import io.everyonecodes.springmodule.task.Task;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Snapshot {
    @Id
    @GeneratedValue
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    @JsonManagedReference
    private ImageData imageData;

    @Basic(optional = false)
    private String rating;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime finishedDate;

    @Column(columnDefinition = "TEXT")
    private String mistakesField;

    @ManyToOne()
    @JoinColumn(name = "task_id")
    @JsonBackReference
    public Task task;

    public Snapshot(Task task, String mistakesField, String rating, ImageData imageData) {
        this.mistakesField = mistakesField;
        this.rating = rating;
        this.task = task;
        this.imageData = imageData;
    }

    @PrePersist
    void setFinishedDateToCurrentDate() {
        this.finishedDate = LocalDateTime.now();
    }
}
