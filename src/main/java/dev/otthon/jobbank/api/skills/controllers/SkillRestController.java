package dev.otthon.jobbank.api.skills.controllers;

import dev.otthon.jobbank.api.skills.assemblers.SkillAssembler;
import dev.otthon.jobbank.api.skills.dtos.SkillRequestDTO;
import dev.otthon.jobbank.api.skills.dtos.SkillResponseDTO;
import dev.otthon.jobbank.api.skills.mappers.SkillMapper;
import dev.otthon.jobbank.core.exceptions.SkillNotFoundException;
import dev.otthon.jobbank.core.repositories.SkillRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/skills")
public class SkillRestController {

    private final SkillMapper skillMapper;
    private final SkillRepository skillRepository;
    private final SkillAssembler skillAssembler;

    @GetMapping
    public CollectionModel<EntityModel<SkillResponseDTO>> findAll() {
        var skills =  skillRepository.findAll()
                .stream()
                .map(skillMapper::toSkillResponseDTO)
                .toList();
        // Montando o HATEOAS
        return skillAssembler.toCollectionModel(skills);
    }

    @GetMapping("/{id}")
    public EntityModel<SkillResponseDTO> findById(@PathVariable Long id) {
        var skill = skillRepository.findById(id)
                .map(skillMapper::toSkillResponseDTO)
                .orElseThrow(SkillNotFoundException::new);
        // Montando o HATEOAS
        return skillAssembler.toModel(skill);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public EntityModel<SkillResponseDTO> create(@RequestBody @Valid SkillRequestDTO skillRequestDTO) {
        var skill = skillMapper.toSkill(skillRequestDTO);
        skill = skillRepository.save(skill);
        var skillResponse = skillMapper.toSkillResponseDTO(skill);

        return skillAssembler.toModel(skillResponse);
    }

    @PutMapping("/{id}")
    public EntityModel<SkillResponseDTO> update(@PathVariable Long id, @Valid @RequestBody SkillRequestDTO skillRequestDTO) {
        var skill = skillRepository.findById(id)
                .orElseThrow(SkillNotFoundException::new);
        BeanUtils.copyProperties(skillRequestDTO, skill, "id");
        skill = skillRepository.save(skill);
        var skillResponse = skillMapper.toSkillResponseDTO(skill);
        return skillAssembler.toModel(skillResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        var skill = skillRepository.findById(id)
                .orElseThrow(SkillNotFoundException::new);
        skillRepository.delete(skill);
        return ResponseEntity.noContent().build();
    }

}
