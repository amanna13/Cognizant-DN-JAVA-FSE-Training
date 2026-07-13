package com.cognizant.springjpaqueries.service;

import com.cognizant.springjpaqueries.model.Skill;
import com.cognizant.springjpaqueries.repository.SkillRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SkillService {

    private static final Logger logger = LoggerFactory.getLogger(SkillService.class);

    @Autowired
    private SkillRepository skillRepository;

    @Transactional
    public void saveSkill(Skill skill) {
        logger.info("Start");
        skillRepository.save(skill);
        logger.info("End");
    }

    @Transactional
    public Optional<Skill> getSkillById(Integer id) {
        logger.info("Start");
        return skillRepository.findById(id);
    }
}
