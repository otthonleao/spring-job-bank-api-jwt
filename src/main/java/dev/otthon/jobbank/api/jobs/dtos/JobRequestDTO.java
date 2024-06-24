package dev.otthon.jobbank.api.jobs.dtos;

import dev.otthon.jobbank.core.enums.JobLevel;
import dev.otthon.jobbank.core.enums.JobType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobRequestDTO {

    @NotEmpty
    @Size(min = 5, max = 100)
    private String title;

    @NotEmpty
    @Size(min = 10, max = 255)
    private String description;

    @NotEmpty
    @Size(min = 3, max = 50)
    private String company;

    @NotEmpty
    @Size(min = 3, max = 100)
    private String location;

    @NotNull
    private JobType type;

    @NotNull
    private JobLevel level;

    @NotNull
    @Positive
    private BigDecimal salary;

    @NotEmpty
    private List<Long> skills;

}
