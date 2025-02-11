package com.employee.EmployeeManagementSystem.Service;

import com.employee.EmployeeManagementSystem.Entity.Skill;
import com.employee.EmployeeManagementSystem.Repository.SkillRepository;
import com.employee.EmployeeManagementSystem.SkillNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;

    public Skill addSkill(Skill skill) {

        log.info("Adding new skill: {}", skill);
        return skillRepository.save(skill);
    }

    public Skill getSkillById(Long id) {
        log.info("Fetching skill with ID: {}", id);
        return skillRepository.findById(id)
                .orElseThrow(() -> new SkillNotFoundException("Skill not found with ID: " + id));
    }

    public List<Skill> getAllSkills() {
        log.info("Fetching all skills");
        return skillRepository.findAll();
    }
}
