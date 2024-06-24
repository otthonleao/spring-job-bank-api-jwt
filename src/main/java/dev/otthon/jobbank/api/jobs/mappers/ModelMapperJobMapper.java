package dev.otthon.jobbank.api.jobs.mappers;

import dev.otthon.jobbank.api.jobs.dtos.JobRequestDTO;
import dev.otthon.jobbank.api.jobs.dtos.JobResponseDTO;
import dev.otthon.jobbank.core.models.Job;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ModelMapperJobMapper implements JobMapper{

    private final ModelMapper modelMapper;

    @Override
    public JobResponseDTO toJobResponse(Job job) {
        return modelMapper.map(job, JobResponseDTO.class);
    }

    @Override
    public Job toJob(JobRequestDTO jobRequestDTO) {
        return modelMapper.map(jobRequestDTO, Job.class);
    }
}
