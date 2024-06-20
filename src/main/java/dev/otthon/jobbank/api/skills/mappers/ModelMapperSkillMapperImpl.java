package dev.otthon.jobbank.api.skills.mappers;

import dev.otthon.jobbank.api.skills.dtos.SkillRequestDTO;
import dev.otthon.jobbank.api.skills.dtos.SkillResponseDTO;
import dev.otthon.jobbank.core.models.Skill;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ModelMapperSkillMapperImpl implements SkillMapper {

    private final ModelMapper modelMapper;

    @Override
    public Skill toSkill(SkillRequestDTO skillRequestDTO) {
        return modelMapper.map(skillRequestDTO, Skill.class);
    }

    @Override
    public SkillResponseDTO toSkillResponseDTO(Skill skill) {
        return modelMapper.map(skill, SkillResponseDTO.class);
    }
}
