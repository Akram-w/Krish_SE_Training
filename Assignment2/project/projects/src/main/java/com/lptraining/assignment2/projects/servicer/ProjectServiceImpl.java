package com.lptraining.assignment2.projects.servicer;

import com.lptraining.assignment2.commons.models.Project;
import com.lptraining.assignment2.commons.models.Task;
import com.lptraining.assignment2.commons.models.TaskUnderProject;
import com.lptraining.assignment2.projects.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository repository;

    @Autowired
    RestTemplate restTemplate;

    @Bean
    RestTemplate getRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }


    @Override
    public Project save(Project project) {
        return repository.save(project);
    }

    @Override
    public Project update(Project project, int id) {
        project.setId(id);
        Project saved = repository.save(project);
        return saved;
    }

    @Override
    public void delete(int id) {
        deleteAlTasksUnderProject(id);
        repository.deleteById(id);
    }

    @Override
    public List<Project> getAllProjects() {
        return repository.findAll();
    }

    @Override
    public Project getProjectById(int id) {
        Optional<Project> projectById = repository.findById(id);

        if (projectById.isPresent()) {
            return projectById.get();
        }
        return null;
    }

    @Override
    public TaskUnderProject getProjectByIdWithTasks(int id) {
        Optional<Project> projectById = repository.findById(id);

        if (projectById.isPresent()) {
            return new TaskUnderProject(projectById.get(), getAllTasksUnderProject(projectById.get().getId()));
        }
        return null;
    }

    @Override
    public Project isProjectActive(int id) {
        return getProjectById(id);
    }

    @Override
    public List<Project> getAllTaskWithEndDate(LocalDate date) {
        return repository.findByProjectEndDate(date);
    }

    @Override
    public List<Project> getAllTaskByStatus(Boolean status) {
        return repository.findByIsActive(status);
    }

    private List<Task> getAllTasksUnderProject(int projectId) {
        String uri = "http://localhost:8191/tasks?projectId=" + projectId;
        return restTemplate.getForObject(uri, List.class);
    }

    private void deleteAlTasksUnderProject(int projectId) {
        String uri = "http://localhost:8191/tasks/project/" + projectId;
        restTemplate.delete(uri);
    }
}