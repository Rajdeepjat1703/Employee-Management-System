package com.employee.EmployeeManagementSystem.Controller;

import com.employee.EmployeeManagementSystem.Entity.Skill;
import com.employee.EmployeeManagementSystem.Service.SkillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/skills")
public class SkillController {
    @Autowired
    private SkillService skillService;

    @PostMapping
    public ResponseEntity<Skill> addSkill(@RequestBody Skill skill) {
        log.info("Received request to add skill: {}", skill);
        return ResponseEntity.ok(skillService.addSkill(skill));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Skill> getSkillById(@PathVariable Long id) {
        log.info("Received request to fetch skill with ID: {}", id);
        return ResponseEntity.ok(skillService.getSkillById(id));
    }


}
