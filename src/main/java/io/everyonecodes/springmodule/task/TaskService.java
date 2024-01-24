package io.everyonecodes.springmodule.task;

import io.everyonecodes.springmodule.snapshot.Snapshot;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> findAllActivatedTasks() {
        return repository.findByIsArchivedIsFalse();
    }

    public List<Task> findALlArchivedTasks() {
        return repository.findByIsArchivedIsTrue();
    }

    public Optional<Task> findById(@PathVariable long id) {
        return repository.findById(id);
    }

    public void deleteById(@PathVariable long id) {
        repository.deleteById(id);
    }

    public Task save(@RequestBody Task task) {
        return repository.save(task);
    }

    public void deleteAll(List<Task> tasks) {
        repository.deleteAll(tasks);
    }

    public Task update(@RequestBody Task updatedTask, @PathVariable long id) {
        Task task = repository.findById(id).orElse(null);

        try {
            if (updatedTask.getTitle() != null) {
                task.setTitle(updatedTask.getTitle());
            } else if (updatedTask.getDescription() != null) {
                task.setDescription(updatedTask.getDescription());
            } else if (updatedTask.isArchived() != task.isArchived()) {
                task.setArchived(updatedTask.isArchived());
            }
        } catch (NullPointerException e) {
            System.out.println("No task with this ID found.");
        }
        return repository.save(task);
    }
}

