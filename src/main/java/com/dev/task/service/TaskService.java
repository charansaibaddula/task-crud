package com.dev.task.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.task.entity.Task;
import com.dev.task.repository.TaskRepository;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task Not Found"));
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public String setCompleted(Long id) {
        taskRepository.setCompleted(id);
        return "Task Completed";
    }
}
