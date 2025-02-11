package com.employee.EmployeeManagementSystem.Service;

import com.employee.EmployeeManagementSystem.EmployeeNotFoundException;
import com.employee.EmployeeManagementSystem.Entity.Employee;
import com.employee.EmployeeManagementSystem.Entity.Project;
import com.employee.EmployeeManagementSystem.Entity.Skill;
import com.employee.EmployeeManagementSystem.ProjectNotFoundException;
import com.employee.EmployeeManagementSystem.Repository.EmployeeRepository;
import com.employee.EmployeeManagementSystem.Repository.ProjectRepository;
import com.employee.EmployeeManagementSystem.Repository.SkillRepository;
import com.employee.EmployeeManagementSystem.SkillNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
@Slf4j
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private RedisTemplate<String, Employee> redisTemplate;

    private static final String EMPLOYEE_CACHE = "EmployeeCache";

    public Employee addEmployee(Employee employee) {
        log.info("Adding employee: {}", employee);
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        log.info("Updating employee with ID: {}", id);
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: " + id));
        employee.setName(employeeDetails.getName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setRole(employeeDetails.getRole());
        employee.setDepartment(employeeDetails.getDepartment());
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        log.info("Deleting employee with ID: {}", id);
        employeeRepository.deleteById(id);
        redisTemplate.opsForHash().delete(EMPLOYEE_CACHE, id);
    }

    public Employee getEmployeeById(Long id) {
        log.info("Fetching employee with ID: {}", id);
        Employee employee = (Employee) redisTemplate.opsForHash().get(EMPLOYEE_CACHE, id);
        if (employee == null) {
            employee = employeeRepository.findById(id)
                    .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: " + id));
            redisTemplate.opsForHash().put(EMPLOYEE_CACHE, id, employee);
        }
        return employee;
    }

    public Employee addSkillToEmployee(Long employeeId, Long skillId) {
        log.info("Adding skill with ID: {} to employee with ID: {}", skillId, employeeId);
        Employee employee = getEmployeeById(employeeId);
        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new SkillNotFoundException("Skill not found with ID: " + skillId));
        employee.getSkills().add(skill);
        return employeeRepository.save(employee);
    }

    public Employee assignProjectToEmployee(Long employeeId, Long projectId) {
        log.info("Assigning project with ID: {} to employee with ID: {}", projectId, employeeId);
        Employee employee = getEmployeeById(employeeId);
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException("Project not found with ID: " + projectId));
        employee.getProjects().add(project);
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees");
        return employeeRepository.findAll();
    }
}
