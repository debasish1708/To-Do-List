package com.example.TodoListApp.service;

import com.example.TodoListApp.entity.ToDoEntry;
import com.example.TodoListApp.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ToDoServices {
    private final ToDoRepository todoRepository;

    public void saveEntry(ToDoEntry entry){
        todoRepository.save(entry);
    }

    public List<ToDoEntry> getAllEntries(){
        return todoRepository.findAll();
    }

    public void deleteEntry(String id){
        todoRepository.deleteById(id);
    }
}
