package com.cognizant.springjpaqueries.repository;

import com.cognizant.springjpaqueries.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
}
