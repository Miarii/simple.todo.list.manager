package com.api.todo.list.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.todo.list.model.Task;
import com.api.todo.list.service.TaskService;

// TaskController class to handle HTTP requests for task management
@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    
    @Autowired
    private TaskService taskService;

    // Endpoint to create a new task
    // Expects task data in JSON format
    @PostMapping
    public Task createTask(@RequestBody Map<String, Object> taskData) {
        Task task = new Task();
        
        // Assumes taskData map contains all necessary fields
        task.setTitle((String) taskData.get("title"));

        // Handle conversion for 'completed' field from String to boolean
        String completed = (String) taskData.get("completed");
        task.setCompleted("oui".equalsIgnoreCase(completed));

        return taskService.createTask(task);
    }

    // Endpoint to get all tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // Endpoint to get a single task by its ID
    // Returns 404 Not Found if the task is not present
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable int id) {
        return taskService.getTaskById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    // Endpoint to update an existing task by ID
    // Accepts task updates in JSON format
    // Returns 404 Not Found if the task to update is not found
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable int id, @RequestBody Map<String, Object> taskDetails) {
        return taskService.getTaskById(id)
                .map(existingTask -> {
                    existingTask.setTitle((String) taskDetails.get("title"));
                    
                    // Handle conversion for 'completed' field from String to boolean
                    String completed = (String) taskDetails.get("completed");
                    existingTask.setCompleted("oui".equalsIgnoreCase(completed));

                    return ResponseEntity.ok(taskService.updateTask(existingTask));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint to delete a task by its ID
    // Returns 404 Not Found if the task to delete is not found
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable int id) {
        return taskService.getTaskById(id)
                .map(task -> {
                    taskService.deleteTask(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
