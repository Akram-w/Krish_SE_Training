package com.training.assignment2.projects.controllers;

import com.training.assignment2.commons.models.project.Project;
import com.training.assignment2.commons.models.responsemodels.TaskUnderProject;
import com.training.assignment2.projects.servicer.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
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
            return ResponseEntity.status(HttpStatus.OK).body("Project has deleted");
        } catch (EmptyResultDataAccessException erda) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Couldn't find given project");
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
    public ResponseEntity getProjectById(@PathVariable int id) {
        TaskUnderProject projectById = projectService.getProjectByIdWithTasks(id);

        if (projectById == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Couldn't find give project");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(projectById);
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
    public ResponseEntity getAllProjectsByEndDate(@RequestParam(value = "endDate") String endDate) {
        System.out.println(endDate);
        try {
            List<Project> allTaskWithEndDate = projectService.getAllTaskWithEndDate(LocalDate.parse(endDate));

            return ResponseEntity.status(HttpStatus.OK).body(allTaskWithEndDate);
        } catch (DateTimeParseException ex) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Given date is not valid");
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
