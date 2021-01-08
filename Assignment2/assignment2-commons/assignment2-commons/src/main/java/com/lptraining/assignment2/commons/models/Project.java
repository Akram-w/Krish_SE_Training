package com.lptraining.assignment2.commons.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue
    int id;

    String projectName;
    String projectLeadName;
    String projectDescription;
    LocalDate projectEndDate;
    boolean isActive;

    public Project() {
    }

    public Project(int id, String projectName, String projectLeadName, String projectDescription, LocalDate projectEndDate, boolean isActive) {
        this.id = id;
        this.projectName = projectName;
        this.projectLeadName = projectLeadName;
        this.projectDescription = projectDescription;
        this.projectEndDate = projectEndDate;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectLeadName() {
        return projectLeadName;
    }

    public void setProjectLeadName(String projectLeadName) {
        this.projectLeadName = projectLeadName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }

    public LocalDate getProjectEndDate() {
        return projectEndDate;
    }

    public void setProjectEndDate(LocalDate projectEndDate) {
        this.projectEndDate = projectEndDate;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", projectLeadName='" + projectLeadName + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", projectEndDate=" + projectEndDate +
                ", isActive=" + isActive +
                '}';
    }
}
