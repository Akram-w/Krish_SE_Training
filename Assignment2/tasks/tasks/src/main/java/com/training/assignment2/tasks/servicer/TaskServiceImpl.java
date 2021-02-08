package com.training.assignment2.tasks.servicer;

import com.training.assignment2.commons.models.project.Project;
import com.training.assignment2.commons.models.responsemodels.TaskUnderProject;
import com.training.assignment2.commons.models.task.Task;
import com.training.assignment2.commons.models.responsemodels.TaskWithProject;
import com.training.assignment2.tasks.exceptions.ProjectNotActive;
import com.training.assignment2.tasks.exceptions.ProjectNotExists;
import com.training.assignment2.tasks.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    RestTemplate restTemplate;

    @Bean
    RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Override
    public Task save(Task task) throws ProjectNotActive, ProjectNotExists {
        String projectStatus = isActiveProject(task.getProjectId());
        if (projectStatus.equals("ACTIVE")) {
            return taskRepository.save(task);
        } else if (projectStatus.equals("NOT-ACTIVE")) {
            throw new ProjectNotActive("Project under id :" + task.getProjectId() + " not active");
        } else if (projectStatus.equals("NOT-FOUND")) {
            throw new ProjectNotExists("Project under id: " + task.getProjectId() + "not active");
        }
        return null;
    }

    @Override
    public Task update(Task task, int id) throws ProjectNotActive, ProjectNotExists {
        String projectStatus = isActiveProject(task.getProjectId());
        if (projectStatus.equals("ACTIVE")) {
            task.setId(id);
            return taskRepository.save(task);
        } else if (projectStatus.equals("NOT-ACTIVE")) {
            throw new ProjectNotActive("Project under id :" + task.getProjectId() + " not active");
        } else if (projectStatus.equals("NOT-FOUND")) {
            throw new ProjectNotExists("Project under id: " + task.getProjectId() + "not active");
        }
        return null;
    }

    @Override
    public List<Task> fetchAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public TaskWithProject fetchTaskById(int id) {
        Optional<Task> taskById = taskRepository.findById(id);
        if (taskById.isPresent()) {

            return new TaskWithProject(taskById.get(), getProjectById(taskById.get().getProjectId()));
        }
        return null;
    }

    @Override
    public List<Task> getAllTaskWithEndDate(LocalDate endDate) {
        return taskRepository.findByTaskEndDate(endDate);
    }

    @Override
    public void removeTaskById(int id) {
            taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getAllTaskByStatus(boolean status) {
        return taskRepository.findByIsActive(status);
    }

    @Override
    public List<Task> getAllTaskByProjectIdAndStatus(int id, boolean status) {
        return taskRepository.findByProjectIdAndIsActive(id,status);
    }

    @Override
    public List<Task> getAllTaskByProjectId(int id) {
        return taskRepository.findByProjectId(id);
    }

    @Transactional
    @Override
    public void deleteTasksByProjectId(int projectIid) {
        taskRepository.deleteByProjectId(projectIid);
    }

    private String isActiveProject(int projectId) {
        String uri = "http://localhost:8080/projects/" + projectId + "/isActive";
        String projectStatus = restTemplate.getForObject(uri, String.class);
        System.out.println(projectStatus);
        return projectStatus;
    }

    private Project getProjectById(int id) {
        String uri = "http://localhost:8080/projects/" + id;
        TaskUnderProject project = restTemplate.getForObject(uri, TaskUnderProject.class);
        System.out.println(uri);
        System.out.println(project.getProject());
        return project.getProject();
    }
}
