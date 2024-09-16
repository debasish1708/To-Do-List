package com.example.TodoListApp.controller;

import com.example.TodoListApp.entity.ToDoEntry;
import com.example.TodoListApp.service.ToDoServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoServices toDoServices;

    @GetMapping
    public List<ToDoEntry> getAll(){
        return toDoServices.getAllEntries();
    }

    @PostMapping
    public ToDoEntry create(@Valid @RequestBody ToDoEntry toDoEntry){
         toDoServices.saveEntry(toDoEntry);
         return toDoEntry;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        toDoServices.deleteEntry(id);
    }

}
