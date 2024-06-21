package dev.otthon.jobbank.api.skills.controllers;

import dev.otthon.jobbank.api.skills.dtos.SkillRequestDTO;
import dev.otthon.jobbank.api.skills.dtos.SkillResponseDTO;
import dev.otthon.jobbank.api.skills.mappers.SkillMapper;
import dev.otthon.jobbank.core.exceptions.SkillNotFoundException;
import dev.otthon.jobbank.core.repositories.SkillRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public SkillResponseDTO findById(@PathVariable Long id) {
        return skillRepository.findById(id)
                .map(skillMapper::toSkillResponseDTO)
                .orElseThrow(SkillNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public SkillResponseDTO create(@RequestBody @Valid SkillRequestDTO skillRequestDTO) {
        var skill = skillMapper.toSkill(skillRequestDTO);
        skill = skillRepository.save(skill);
        return skillMapper.toSkillResponseDTO(skill);
    }

    @PutMapping("/{id}")
    public SkillResponseDTO update(@PathVariable Long id, @Valid @RequestBody SkillRequestDTO skillRequestDTO) {
        var skill = skillRepository.findById(id)
                .orElseThrow(SkillNotFoundException::new);
        BeanUtils.copyProperties(skillRequestDTO, skill, "id");
        skill = skillRepository.save(skill);
        return skillMapper.toSkillResponseDTO(skill);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        var skill = skillRepository.findById(id)
                .orElseThrow(SkillNotFoundException::new);
        skillRepository.delete(skill);
    }

}
