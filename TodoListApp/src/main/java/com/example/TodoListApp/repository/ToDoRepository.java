package com.example.TodoListApp.repository;

import com.example.TodoListApp.entity.ToDoEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToDoRepository extends MongoRepository<ToDoEntry, String> {
}
