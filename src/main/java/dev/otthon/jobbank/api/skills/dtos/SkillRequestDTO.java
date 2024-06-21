package dev.otthon.jobbank.api.skills.dtos;

import dev.otthon.jobbank.core.validators.SkillNameIsUnique;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillRequestDTO {

    @NotEmpty
    @SkillNameIsUnique
    private String name;

}
