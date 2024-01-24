package io.everyonecodes.springmodule.snapshot;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class SnapshotService {

    private SnapshotRepository repository;

    public SnapshotService(SnapshotRepository repository) {
        this.repository = repository;
    }

    public List<Snapshot> findAll() {
        return repository.findAll();
    }

    public List<Snapshot> findALlFromTask(@PathVariable long taskId) {
        return repository.findAll()
                .stream()
                .filter(e -> e.task.getId() == taskId)
                .toList();
    }

    public Snapshot findById(@PathVariable long id) {
        return repository.findById(id).orElse(null);
    }

    public Snapshot createAndAnd(@RequestBody Snapshot snapshot) {
        return repository.save(snapshot);
    }
}
