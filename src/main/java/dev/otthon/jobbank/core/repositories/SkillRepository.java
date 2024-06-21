package dev.otthon.jobbank.core.repositories;

import dev.otthon.jobbank.core.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {

    boolean existsByName(String name);

    boolean existsByNameAndIdNot(String name, Long ig);

}
