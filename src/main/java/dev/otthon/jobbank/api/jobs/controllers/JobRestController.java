package dev.otthon.jobbank.api.jobs.controllers;

import dev.otthon.jobbank.api.jobs.dtos.JobRequestDTO;
import dev.otthon.jobbank.api.jobs.dtos.JobResponseDTO;
import dev.otthon.jobbank.api.jobs.mappers.JobMapper;
import dev.otthon.jobbank.api.skills.dtos.SkillResponseDTO;
import dev.otthon.jobbank.api.skills.mappers.ModelMapperSkillMapperImpl;
import dev.otthon.jobbank.api.skills.mappers.SkillMapper;
import dev.otthon.jobbank.core.exceptions.JobNotFoundException;
import dev.otthon.jobbank.core.repositories.JobRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jobs")
public class JobRestController {

    private final JobMapper jobMapper;
    private final JobRepository jobRepository;
    private final SkillMapper skillMapper;

    @GetMapping
    public List<JobResponseDTO> findAll() {
        return jobRepository.findAll()
                .stream()
                .map(jobMapper::toJobResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public JobResponseDTO findById(@PathVariable Long id) {
        var job = jobRepository.findById(id)
                .orElseThrow(JobNotFoundException::new);
        return jobMapper.toJobResponse(job);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public JobResponseDTO create(@RequestBody @Valid JobRequestDTO jobRequestDTO) {
        var job = jobMapper.toJob(jobRequestDTO);
        job = jobRepository.save(job);
        return jobMapper.toJobResponse(job);
    }

    @PutMapping("/{id}")
    public JobResponseDTO update(@PathVariable Long id, @RequestBody @Valid JobRequestDTO jobRequestDTO) {
        var job = jobRepository.findById(id).orElseThrow(JobNotFoundException::new);

        var jobData = jobMapper.toJob(jobRequestDTO);
        BeanUtils.copyProperties(jobData, job, "id");
        job = jobRepository.save(job);
        return jobMapper.toJobResponse(job);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        var job = jobRepository.findById(id)
                .orElseThrow(JobNotFoundException::new);
        jobRepository.delete(job);
        return ResponseEntity.noContent().build();
    }

}
