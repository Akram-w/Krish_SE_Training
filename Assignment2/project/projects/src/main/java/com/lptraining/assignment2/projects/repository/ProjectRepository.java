package com.lptraining.assignment2.projects.repository;

import com.lptraining.assignment2.commons.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
    List<Project> findByProjectEndDate(LocalDate date);
    List<Project> findByIsActive(boolean status);
}
