package dev.otthon.jobbank.api.skills.controllers;

import dev.otthon.jobbank.api.skills.dtos.SkillResponseDTO;
import dev.otthon.jobbank.api.skills.mappers.SkillMapper;
import dev.otthon.jobbank.core.repositories.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/skills")
public class SkillRestController {

    private final SkillMapper skillMapper;
    private final SkillRepository skillRepository;

    @GetMapping
    public List<SkillResponseDTO> findAll() {
        return skillRepository.findAll()
                .stream()
                .map(skillMapper::toSkillResponseDTO)
                .toList();
    }

}
