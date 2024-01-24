package io.everyonecodes.springmodule;

import io.everyonecodes.springmodule.image.ImageData;
import io.everyonecodes.springmodule.snapshot.Snapshot;
import io.everyonecodes.springmodule.snapshot.SnapshotRepository;
import io.everyonecodes.springmodule.task.Task;
import io.everyonecodes.springmodule.task.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DatabasePreloader {
    @Bean
    CommandLineRunner initDatabase(TaskRepository taskRepo, SnapshotRepository snapshotRepo) {
        return args -> {
            List<Task> tasks = new ArrayList<>(List.of(
                    new Task("first title (1)", "first content as description of task 1"),
                    new Task("second title (2)", "second content as description of task 2"),
                    new Task("third title (3)", "third content as description of task 3")
            ));

            List<Snapshot> snapshots = new ArrayList<>(List.of(
                    new Snapshot(tasks.get(2),"some mistakes", "very unsatisfied", new ImageData("path")),
                    new Snapshot(tasks.get(1),"some mistakes", "satisfied", new ImageData("path"))));

            taskRepo.saveAll(tasks);
            snapshotRepo.saveAll(snapshots);
        };
    }
}
