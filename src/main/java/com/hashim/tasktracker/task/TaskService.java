package com.hashim.tasktracker.task;

import com.hashim.tasktracker.task.dto.CreateTaskRequest;
import com.hashim.tasktracker.task.dto.TaskResponse;
import com.hashim.tasktracker.task.dto.UpdateTaskRequest;
import com.hashim.tasktracker.task.error.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public TaskResponse create(CreateTaskRequest req) {
        Task t = new Task();
        t.setTitle(req.getTitle());
        t.setDescription(req.getDescription());
        Task saved = repo.save(t);
        return toResponse(saved);
    }

    public List<TaskResponse> getAll() {
        return repo.findAll().stream().map(this::toResponse).toList();
    }

    public TaskResponse getById(Long id) {
        Task t = repo.findById(id).orElseThrow(() -> new NotFoundException("Task not found: " + id));
        return toResponse(t);
    }

    public TaskResponse update(Long id, UpdateTaskRequest req) {
        Task t = repo.findById(id).orElseThrow(() -> new NotFoundException("Task not found: " + id));
        t.setTitle(req.getTitle());
        t.setDescription(req.getDescription());
        Task saved = repo.save(t);
        return toResponse(saved);
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Task not found: " + id);
        }
        repo.deleteById(id);
    }

    private TaskResponse toResponse(Task t) {
        return new TaskResponse(t.getId(), t.getTitle(), t.getDescription());
    }
}
