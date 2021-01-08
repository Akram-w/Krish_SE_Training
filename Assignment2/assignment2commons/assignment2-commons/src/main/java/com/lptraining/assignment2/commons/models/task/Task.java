package com.lptraining.assignment2.commons.models.task;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue
    int id;
    String taskName;
    String taskDescription;
    LocalDate taskEndDate;
    boolean isActive;
    int projectId;

    public Task() {
    }

    public Task(int id, String taskName, String taskDescription, LocalDate taskEndDate, boolean isActive, int projectId) {
        this.id = id;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskEndDate = taskEndDate;
        this.isActive = isActive;
        this.projectId = projectId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public LocalDate getTaskEndDate() {
        return taskEndDate;
    }

    public void setTaskEndDate(LocalDate taskEndDate) {
        this.taskEndDate = taskEndDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskEndDate=" + taskEndDate +
                ", isActive=" + isActive +
                ", projectId=" + projectId +
                '}';
    }
}
