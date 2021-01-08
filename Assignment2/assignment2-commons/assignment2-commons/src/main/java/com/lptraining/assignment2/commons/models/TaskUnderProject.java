package com.lptraining.assignment2.commons.models;

import java.util.List;

public class TaskUnderProject {
    Project project;
    List<Task> taskList;

    public TaskUnderProject(Project project, List<Task> taskList) {
        this.project = project;
        this.taskList = taskList;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
