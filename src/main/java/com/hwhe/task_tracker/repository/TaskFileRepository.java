package com.hwhe.task_tracker.repository;

import com.hwhe.task_tracker.model.Task;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

public class TaskFileRepository {

  static ObjectMapper objmap = new ObjectMapper();
  private static Path jsonPath = Paths.get("target/tasks.json");
  private static List<Task> tasks;

  public static List<Task> loadTasks() {
    tasks = objmap.readValue(jsonPath, new TypeReference<List<Task>>() {});
    return tasks;
  }

  public static void saveTasks(List<Task> newTasks) {
    objmap.writeValue(jsonPath, newTasks);
  }

  public static void checkFile() throws IOException {
    if (!Files.exists(jsonPath)) {
      Files.write(jsonPath, "[]".getBytes());
    }
  }
}
