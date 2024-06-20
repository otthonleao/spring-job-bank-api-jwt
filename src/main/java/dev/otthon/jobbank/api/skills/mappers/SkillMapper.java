package dev.otthon.jobbank.api.skills.mappers;

import dev.otthon.jobbank.api.skills.dtos.SkillRequestDTO;
import dev.otthon.jobbank.api.skills.dtos.SkillResponseDTO;
import dev.otthon.jobbank.core.models.Skill;

public interface SkillMapper {

    // Recebe uma requisicao para ser transformado em uma Skill e ser salva no banco
    Skill toSkill(SkillRequestDTO skillRequestDTO);

    // Recebe uma Skill do banco e transforma em SkillResponseDTO para enviar a resposta
    SkillResponseDTO toSkillResponseDTO(Skill skill);

}
