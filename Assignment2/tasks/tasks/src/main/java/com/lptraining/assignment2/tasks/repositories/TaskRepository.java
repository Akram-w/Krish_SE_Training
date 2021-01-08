package com.lptraining.assignment2.tasks.repositories;

import com.lptraining.assignment2.commons.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;


public interface TaskRepository extends JpaRepository<Task,Integer> {

    List<Task> findByTaskEndDate(LocalDate taskEndDate);
    List<Task> findByIsActive(boolean status);
    List<Task> findByProjectIdAndIsActive(int id,boolean status);
    List<Task> findByProjectId(int id);
    void deleteByProjectId(int projectIid);

}
