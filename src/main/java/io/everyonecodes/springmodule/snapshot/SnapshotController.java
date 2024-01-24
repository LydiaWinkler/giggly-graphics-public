package io.everyonecodes.springmodule.snapshot;

import io.everyonecodes.springmodule.task.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class SnapshotController {
    private SnapshotService snapshotService;
    private TaskService taskService;

    public SnapshotController(SnapshotService snapshotService, TaskService taskService) {
        this.snapshotService = snapshotService;
        this.taskService = taskService;
    }

    @GetMapping("/snapshots")
    public List<Snapshot> findAll() {
        return snapshotService.findAll();
    }

    @GetMapping("/snapshots/{id}")
    public Snapshot findById(@PathVariable long id) {
        return snapshotService.findById(id);
    }

    @GetMapping("/tasks/{id}/snapshots")
    public List<Snapshot> findALlByTaskId(@PathVariable long id) {
        return snapshotService.findALlFromTask(id);
    }

    @PostMapping("/tasks/{id}/snapshot")
    public Snapshot createAndAdd(@RequestBody Snapshot snapshot, @PathVariable long id) {
        try {
            snapshot.setTask(taskService.findById(id).get());
        } catch (NoSuchElementException e) {
            System.out.println("no task at id:" + id);
        }
        return snapshotService.createAndAnd(snapshot);
    }
}
