package com.lptraining.assignment2.projects.controllers;

import com.lptraining.assignment2.commons.models.Project;
import com.lptraining.assignment2.commons.models.TaskUnderProject;
import com.lptraining.assignment2.projects.servicer.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;

    /*
            save project by id
    **/
    @PostMapping(value = "/projects")
    public Project saveProject(@RequestBody Project project) {
        return projectService.save(project);
    }

    /*
            update project by id
    **/
    @PutMapping(value = "/projects/{id}")
    public ResponseEntity<Project> updateProject(@RequestBody Project project, @PathVariable int id) {
        Project updatedProject = projectService.update(project, id);

        return ResponseEntity.ok().body(updatedProject);
    }

    /*
            delete project by id
    **/
    @DeleteMapping(value = "/projects/{id}")
    public ResponseEntity deleteProject(@PathVariable int id) {
        try {
            projectService.delete(id);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException erda) {
            return ResponseEntity.notFound().build();
        }
    }

    /*
            fetch all projects
    **/
    @GetMapping(value = "/projects")
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    /*
            fetch  projects by projectId
    **/
    @GetMapping(value = "/projects/{id}")
    public ResponseEntity<TaskUnderProject> getProjectById(@PathVariable int id) {
        TaskUnderProject projectById = projectService.getProjectByIdWithTasks(id);

        if (projectById == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(projectById);
        }
    }

    /*
            check whether project is active or not
    **/
    @GetMapping(value = "/projects/{id}/isActive")
    public String checkProjectIsActive(@PathVariable int id) {
        Project isProjectActive = projectService.isProjectActive(id);

        if (isProjectActive == null) {
            return "NOT-FOUND";
        }
        return isProjectActive.getIsActive() ? "ACTIVE" : "NOT-ACTIVE";
    }

    /*
            fetch  all projects by projectEndDate
    **/
    @GetMapping(value = "/projects", params = "endDate")
    public ResponseEntity<List<Project>> getAllProjectsByEndDate(@RequestParam(value = "endDate") String endDate) {
        System.out.println(endDate);
        try {
            List<Project> allTaskWithEndDate = projectService.getAllTaskWithEndDate(LocalDate.parse(endDate));
            return ResponseEntity.ok().body(allTaskWithEndDate);
        } catch (DateTimeParseException ex) {
            return ResponseEntity.notFound().build();
        }

    }

    /*
            fetch all projects by projectStatus
    **/
    @GetMapping(value = "/projects", params = "status")
    public List<Project> findAllProjectsByStatus(@RequestParam(value = "status") Boolean status) {
        System.out.println(status);
        return projectService.getAllTaskByStatus(status);

    }
}
