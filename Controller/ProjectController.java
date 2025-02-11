package com.employee.EmployeeManagementSystem.Controller;

import com.employee.EmployeeManagementSystem.Entity.Project;
import com.employee.EmployeeManagementSystem.Service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
@Slf4j
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> addProject(@RequestBody Project project) {
        log.info("Received request to add project: {}", project);
        return ResponseEntity.ok(projectService.addProject(project));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        log.info("Received request to fetch project with ID: {}", id);
        return ResponseEntity.ok(projectService.getProjectById(id));
    }


}
