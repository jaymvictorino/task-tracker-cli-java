package com.hwhe.task_tracker.model;

import java.util.Date;

public class Task {

  public enum Status {
    todo,
    in_progress,
    done,
  }

  private long id;
  private String desc;
  private Status status;
  private Date createdAt;
  private Date updatedAt;

  public Task(
    long id,
    String desc,
    Status status,
    Date createdAt,
    Date updatedAt
  ) {
    this.id = id;
    this.desc = desc;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
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

  public Date getCreatedAt() {
    return createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }
}
