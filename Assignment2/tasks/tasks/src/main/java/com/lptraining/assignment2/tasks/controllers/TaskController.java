package com.lptraining.assignment2.tasks.controllers;

import com.lptraining.assignment2.commons.models.task.Task;
import com.lptraining.assignment2.commons.models.responsemodels.TaskWithProject;
import com.lptraining.assignment2.tasks.exceptions.ProjectNotActive;
import com.lptraining.assignment2.tasks.exceptions.ProjectNotExists;
import com.lptraining.assignment2.tasks.servicer.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    /*
        saving task by id
    **/
    @PostMapping(value = "/tasks")
    public ResponseEntity save(@RequestBody Task task) {
        try {
            Task responseTask = taskService.save(task);
            return ResponseEntity.status(HttpStatus.OK).body(responseTask);
        } catch (ProjectNotActive throwables) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Given task's project is Not-Active");
        } catch (ProjectNotExists throwables) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Given task's project is Not-Active");
        }
    }

    /*
           update task by id
    **/
    @PutMapping(value = "/tasks/{id}")
    public ResponseEntity update(@RequestBody Task task, @PathVariable int id) {
        try {
            Task responseTask = taskService.update(task, id);
            return ResponseEntity.ok().body(responseTask);
        } catch (ProjectNotActive throwables) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Given tasks project id is Not-Active");
        } catch (ProjectNotExists throwables) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Given tasks project Not-Found");
        }
    }

    /*
            fetch all the tasks
    **/
    @GetMapping(value = "/tasks")
    public List<Task> getAllTaskByEndDate() {
        return taskService.fetchAllTasks();
    }

    /*
            fetch task by taskId
    **/
    @GetMapping(value = "/tasks/{id}")
    public ResponseEntity findTaskById(@PathVariable int id) {
        TaskWithProject fetchedTask = taskService.fetchTaskById(id);
        if (fetchedTask == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("couldn't find task from given taskId");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(fetchedTask);
        }
    }

    /*
            fetch  all tasks by taskEndDate
    **/
    @GetMapping(value = "/tasks", params = "endDate")
    public ResponseEntity getAllTaskByEndDate(@RequestParam(value = "endDate") String endDate) {
        System.out.println(endDate);
        try {
            List<Task> allTaskWithEndDate = taskService.getAllTaskWithEndDate(LocalDate.parse(endDate));
            return ResponseEntity.ok().body(allTaskWithEndDate);
        } catch (DateTimeParseException ex) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Given Date is not valid");
        }

    }

    /*
            fetch all tasks by taskStatus
    **/
    @GetMapping(value = "/tasks", params = "status")
    public List<Task> findAllTasksByStatus(@RequestParam(value = "status") Boolean status) {
        System.out.println(status);
        return taskService.getAllTaskByStatus(status);

    }

    /*
        fetch task by projectId and taskStatus
    **/
    @GetMapping(value = "/tasks", params = {"projectId", "status"})
    public List<Task> fetchAllTaskByProjectIdAndStatus(@RequestParam(value = "projectId") int id,
                                                       @RequestParam(value = "status") boolean status) {
        return taskService.getAllTaskByProjectIdAndStatus(id, status);
    }

    /*
        fetch all the task by project id
    **/
    @GetMapping(value = "/tasks", params = "projectId")
    public List<Task> fetchAllTaskByProjectId(@RequestParam(value = "projectId") int id) {
        return taskService.getAllTaskByProjectId(id);
    }

    /*
        Remove task by id
    **/
    @DeleteMapping(value = "/tasks/{id}")
    public ResponseEntity removeTask(@PathVariable int id) {
        try {
            taskService.removeTaskById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Task removed");
        } catch (EmptyResultDataAccessException erda) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Couldn't find given task");
        }
    }

    /*
        Remove tasks by projectId
     */
    @DeleteMapping(value = "/tasks/project/{projectId}")
    public ResponseEntity<Boolean> deleteTasksByProjectId(@PathVariable int projectId) {
        try {
            taskService.deleteTasksByProjectId(projectId);
            return ResponseEntity.status(HttpStatus.OK).body(true);
        } catch (EmptyResultDataAccessException erda) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }
}
