package com.lptraining.assignment2.tasks.servicer;

import com.lptraining.assignment2.commons.models.task.Task;
import com.lptraining.assignment2.commons.models.responsemodels.TaskWithProject;
import com.lptraining.assignment2.tasks.exceptions.ProjectNotActive;
import com.lptraining.assignment2.tasks.exceptions.ProjectNotExists;

import java.time.LocalDate;
import java.util.List;

public interface TaskService {

    Task save(Task task) throws ProjectNotActive, ProjectNotExists;

    Task update(Task task, int id) throws ProjectNotActive, ProjectNotExists;

    List<Task> fetchAllTasks();

    TaskWithProject fetchTaskById(int id);

    List<Task> getAllTaskWithEndDate(LocalDate endDate);

    void removeTaskById(int id);

    List<Task> getAllTaskByStatus(boolean status);

    List<Task> getAllTaskByProjectIdAndStatus(int id, boolean status);

    List<Task> getAllTaskByProjectId(int id);

    void deleteTasksByProjectId(int projectIid);
}
