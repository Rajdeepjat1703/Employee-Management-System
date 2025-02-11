package com.employee.EmployeeManagementSystem.Repository;

import com.employee.EmployeeManagementSystem.Entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {

}
