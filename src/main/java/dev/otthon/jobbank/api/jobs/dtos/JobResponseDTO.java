package dev.otthon.jobbank.api.jobs.dtos;

import dev.otthon.jobbank.core.enums.JobLevel;
import dev.otthon.jobbank.core.enums.JobType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobResponseDTO {

    private Long id;
    private String title;
    private String description;
    private String company;
    private String location;
    private JobType type;
    private JobLevel level;
    private BigDecimal salary;

}