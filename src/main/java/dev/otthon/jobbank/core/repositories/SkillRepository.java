package dev.otthon.jobbank.core.repositories;

import dev.otthon.jobbank.core.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
