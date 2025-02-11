package com.employee.EmployeeManagementSystem.Repository;

import com.employee.EmployeeManagementSystem.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
