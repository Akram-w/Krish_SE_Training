package com.lptraining.assignment2.projects.servicer;

import com.lptraining.assignment2.commons.models.Project;
import com.lptraining.assignment2.commons.models.TaskUnderProject;

import java.time.LocalDate;
import java.util.List;


public interface ProjectService {

    Project save(Project project);
    Project update(Project project,int id);
    void delete(int id);
    List<Project> getAllProjects();
    Project getProjectById(int id);
    Project isProjectActive(int id);
    List<Project> getAllTaskWithEndDate(LocalDate date);
    List<Project> getAllTaskByStatus(Boolean status);
    TaskUnderProject getProjectByIdWithTasks(int id);
}
