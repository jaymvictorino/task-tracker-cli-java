package com.hwhe.task_tracker.shell;

import com.hwhe.task_tracker.model.Task;
import com.hwhe.task_tracker.service.TaskService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.shell.core.command.annotation.Argument;
import org.springframework.shell.core.command.annotation.Command;
import org.springframework.stereotype.Component;

@Component
public class TaskCommands {

  private List<Task> tasks = new ArrayList<>();

  @Command(
    name = "add",
    description = "Add a new task",
    group = "Task Commands"
  )
  public void taskAdd(
    @Argument(index = 0) long id,
    @Argument(index = 1) String desc
  ) {
    TaskService.addTask(id, desc);
  }

  @Command(
    name = "update",
    description = "Update an existing task",
    group = "Task Commands"
  )
  public void taskUpdate(
    @Argument(index = 0) long id,
    @Argument(index = 1) String desc
  ) {
    TaskService.updateTask(id, desc);
  }

  @Command(
    name = "delete",
    description = "Delete an existing task",
    group = "Task Commands"
  )
  public void taskDelete(@Argument(index = 0) long id) {
    for (Task t : tasks) {
      if (t.getId() == id) tasks.remove(t);
      break;
    }
    System.out.println("Task deleted!");
  }

  @Command(
    name = "mark-in-progress",
    description = "Change an existing task's status as \"In-Progress\"",
    group = "Task Commands"
  )
  public void taskMarkInProg(@Argument(index = 0) long id) {
    for (Task t : tasks) {
      if (t.getId() == id) t.setStatus(Task.Status.in_progress);
      break;
    }
    System.out.println("Task marked as In-Progress!");
  }

  @Command(
    name = "mark-done",
    description = "Change an existing task's status as \"Done\"",
    group = "Task Commands"
  )
  public void taskMarkDone(@Argument(index = 0) long id) {
    for (Task t : tasks) {
      if (t.getId() == id) t.setStatus(Task.Status.done);
      break;
    }
    System.out.println("Task marked as Done!");
  }

  @Command(
    name = "list",
    description = "List all tasks",
    group = "Task Commands"
  )
  public void taskList() throws IOException {
    TaskService.listTask();
  }
}
