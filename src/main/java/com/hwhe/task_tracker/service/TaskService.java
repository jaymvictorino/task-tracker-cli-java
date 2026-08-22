package com.hwhe.task_tracker.service;

import com.hwhe.task_tracker.model.Task;
import com.hwhe.task_tracker.repository.TaskFileRepository;
import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
public class TaskService {

  ObjectMapper objmap = new ObjectMapper();
  private static List<Task> tasks;

  @PostConstruct
  void loadTasks() throws IOException {
    TaskFileRepository.checkFile();
    tasks = TaskFileRepository.loadTasks();
  }

  public static void addTask(long id, String desc) {
    Task task = new Task(id, desc, Task.Status.todo);
    tasks.add(task);
    TaskFileRepository.saveTasks(tasks);
    System.out.printf("Task added successfully (ID: %d)%n", id);
  }

  public static void updateTask(long id, String desc) {
    for (Task t : tasks) {
      if (t.getId() == id) {
        t.setDesc(desc);
        break;
      }
    }
    TaskFileRepository.saveTasks(tasks);
    System.out.printf("Task updated successfully (ID: %d)%n", id);
  }

  public static void deleteTask(long id) {
    for (Task t : tasks) {
      if (t.getId() == id) {
        tasks.remove(t);
        break;
      }
    }
    TaskFileRepository.saveTasks(tasks);
    System.out.printf("Task deleted successfully (ID: %d)%n", id);
  }

  public static void listTask() throws IOException {
    tasks.forEach(System.out::println);
  }
}
