package com.api.todo.list.repository;

import com.api.todo.list.model.Task;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

//TaskRepository interface for task entity
//Extends JpaRepository to provide CRUD operations and more for Task entities
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
 // This interface will automatically have methods like save, findById, findAll, deleteById, etc.,
 // due to extending JpaRepository. These methods provide standard CRUD operations for Task entities.
 // Additional custom queries can be defined here if needed.
}
