package dev.otthon.jobbank.api.skills.dtos;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false) // Para eliminar o warning do @Data causado por add o extends
public class SkillResponseDTO extends RepresentationModel<SkillResponseDTO> {

    private Long id;

    private String name;

}
