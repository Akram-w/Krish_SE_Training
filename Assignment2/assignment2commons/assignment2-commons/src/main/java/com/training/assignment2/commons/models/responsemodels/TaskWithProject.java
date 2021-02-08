package com.training.assignment2.commons.models.responsemodels;

import com.training.assignment2.commons.models.task.Task;
import com.training.assignment2.commons.models.project.Project;

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
