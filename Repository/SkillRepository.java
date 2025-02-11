package com.employee.EmployeeManagementSystem.Repository;

import com.employee.EmployeeManagementSystem.Entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

}
