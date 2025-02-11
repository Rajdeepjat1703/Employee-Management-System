package com.employee.EmployeeManagementSystem.Service;

import com.employee.EmployeeManagementSystem.Entity.Project;
import com.employee.EmployeeManagementSystem.ProjectNotFoundException;
import com.employee.EmployeeManagementSystem.Repository.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j

public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project addProject(Project project) {
        if (project == null) {
            log.error("Project object is null");
            throw new IllegalArgumentException("Project cannot be null");
        }
        log.info("Adding new project: {}", project);
        return projectRepository.save(project);
    }

    public Project getProjectById(Long id) {
        log.info("Fetching project with ID: {}", id);
        return projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("Project not found with ID: " + id));
    }

    public List<Project> getAllProjects() {
        log.info("Fetching all projects");
        return projectRepository.findAll();
    }
}
