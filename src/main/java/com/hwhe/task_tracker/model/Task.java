package com.hwhe.task_tracker.model;

import java.time.LocalDate;

public class Task {

  public enum Status {
    todo,
    in_progress,
    done,
  }

  private long id;
  private String desc;
  private Status status;
  private LocalDate createdAt;
  private LocalDate updatedAt;

  public Task(long id, String desc, Status status) {
    this.id = id;
    this.desc = desc;
    this.status = status;
    this.createdAt = LocalDate.now();
    this.updatedAt = LocalDate.now();
  }

  public long getId() {
    return id;
  }

  public String getDesc() {
    return desc;
  }

  public Status getStatus() {
    return status;
  }

  public LocalDate getCreatedAt() {
    return createdAt;
  }

  public LocalDate getUpdatedAt() {
    return updatedAt;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public void setUpdatedAt(LocalDate updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public String toString() {
    return String.format(
      "Task{id=%d, desc='%s', status=%s, createdAt=%s, updatedAt=%s}",
      id,
      desc,
      status,
      createdAt,
      updatedAt
    );
  }
}
