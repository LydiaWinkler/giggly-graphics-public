package io.everyonecodes.springmodule.task;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.everyonecodes.springmodule.snapshot.Snapshot;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    @Basic(optional = false)
    private String title;

    @Basic(optional = false)
    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createDate;

    private boolean isArchived;

    @OneToMany(mappedBy = "task", orphanRemoval = true)
    @JsonManagedReference
    private List<Snapshot> snapshot;

    @PrePersist
    void updateCreateDateToCurrentDate() {
        this.createDate = LocalDateTime.now();
    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.isArchived = false;
    }
}
