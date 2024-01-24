package io.everyonecodes.springmodule.task;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {
    private final TaskService service;
    public TaskController(TaskService service) {
        this.service = service;
    }
    @GetMapping("/tasks")
    public List<Task> findALlActivatedTasks() {
        return service.findAllActivatedTasks();
    }

    @GetMapping("/archive")
    public List<Task> findAllArchivedTasks() {
        return service.findALlArchivedTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task findSingleTask(@PathVariable long id) {
        return service.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, ("Page not found.")));
    }

    @PostMapping("/tasks")
    public Task createAndAdd(@RequestBody Task task) {
        task.updateCreateDateToCurrentDate();
        return service.save(task);
    }

    @DeleteMapping("/tasks/{id}")
    public void delete(@PathVariable long id) {
        service.deleteById(id);
    }

    @DeleteMapping("/tasks")
    public void deleteAllActivatedTasks() {
        service.deleteAll(service.findAllActivatedTasks());
    }

    @DeleteMapping("/archive")
    public void deleteAllArchivedTasks() {
        service.deleteAll(service.findALlArchivedTasks());
    }

    @PutMapping("/tasks/{id}")
    public void update(@RequestBody Task task, @PathVariable long id) {
        service.update(task, id);
    }
}
