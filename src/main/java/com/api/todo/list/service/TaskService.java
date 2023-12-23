package com.api.todo.list.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.todo.list.model.Task;
import com.api.todo.list.repository.TaskRepository;

// TaskService class to handle business logic for task management
@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;

    // Method to create a new task
    // Saves the task entity to the database and returns the saved entity
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // Method to retrieve all tasks
    // Returns a list of all task entities from the database
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Method to retrieve a single task by its ID
    // Returns an Optional containing the task if found, or an empty Optional if not
    public Optional<Task> getTaskById(int id) {
        return taskRepository.findById(id);
    }

    // Method to update an existing task
    // Saves the updated task entity to the database and returns the updated entity
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    // Method to delete a task by its ID
    // Deletes the task entity from the database
    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }
}
