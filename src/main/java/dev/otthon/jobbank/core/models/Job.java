package dev.otthon.jobbank.core.models;

import dev.otthon.jobbank.core.enums.JobLevel;
import dev.otthon.jobbank.core.enums.JobType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Job {

    @Id
    @ToString.Include
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Include
    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, length = 50)
    private String company;

    @Column(nullable = false, length = 100)
    private String location;

    @Column(nullable = false, length = 9)
    @Enumerated(EnumType.STRING)
    private JobType type;

    @Column(nullable = false, length = 9)
    @Enumerated(EnumType.STRING)
    private JobLevel level;

    @Column(nullable = false, scale = 2)
    private BigDecimal salary;

    @ManyToMany
    private List<Skill> skills;

}
