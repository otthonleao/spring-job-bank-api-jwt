package dev.otthon.jobbank.api.jobs.controllers;

import dev.otthon.jobbank.api.skills.dtos.SkillResponseDTO;
import dev.otthon.jobbank.api.skills.mappers.SkillMapper;
import dev.otthon.jobbank.core.exceptions.JobNotFoundException;
import dev.otthon.jobbank.core.repositories.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jobs/{id}/skills")
public class JobSkillsRestController {

    private final SkillMapper skillMapper;
    private final JobRepository jobRepository;

    @GetMapping()
    public List<SkillResponseDTO> findSkillsByJobId(@PathVariable Long id) {
        var job = jobRepository.findById(id)
                .orElseThrow(JobNotFoundException::new);
        return job.getSkills()
                .stream()
                .map(skillMapper::toSkillResponseDTO)
                .toList();
    }

}
