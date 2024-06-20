package dev.otthon.jobbank.api.skills.dtos;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SkillResponseDTO {

    private Long id;

    private String name;

}
