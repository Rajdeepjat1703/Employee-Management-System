package com.employee.EmployeeManagementSystem.Controller;

import com.employee.EmployeeManagementSystem.Entity.Employee;
import com.employee.EmployeeManagementSystem.Service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        log.info("Received request to add employee: {}", employee);
        return ResponseEntity.ok(employeeService.addEmployee(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        log.info("Received request to update employee with ID: {}", id);
        return ResponseEntity.ok(employeeService.updateEmployee(id, employeeDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        log.info("Received request to delete employee with ID: {}", id);
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        log.info("Received request to fetch employee with ID: {}", id);
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PostMapping("/{employeeId}/skills/{skillId}")
    public ResponseEntity<Employee> addSkillToEmployee(@PathVariable Long employeeId, @PathVariable Long skillId) {
        log.info("Received request to add skill with ID: {} to employee with ID: {}", skillId, employeeId);
        return ResponseEntity.ok(employeeService.addSkillToEmployee(employeeId, skillId));
    }

    @PostMapping("/{employeeId}/projects/{projectId}")
    public ResponseEntity<Employee> assignProjectToEmployee(@PathVariable Long employeeId, @PathVariable Long projectId) {
        log.info("Received request to assign project with ID: {} to employee with ID: {}", projectId, employeeId);
        return ResponseEntity.ok(employeeService.assignProjectToEmployee(employeeId, projectId));
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        log.info("Received request to fetch all employees");
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
}
