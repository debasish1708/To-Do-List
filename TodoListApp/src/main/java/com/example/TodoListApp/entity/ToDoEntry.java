package com.example.TodoListApp.entity;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "todoList")
@Data
public class ToDoEntry {
    @Id
    private String id;
    @NotNull
    private String text;
}
