package com.lptraining.assignment2.commons.models;

public class TaskWithProject {
    Task task;
    Project project;

    public TaskWithProject() {
    }

    public TaskWithProject(Task task, Project project) {
        this.task = task;
        this.project = project;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
