package dev.otthon.jobbank.api.jobs.mappers;

import dev.otthon.jobbank.api.jobs.dtos.JobResponseDTO;
import dev.otthon.jobbank.core.models.Job;

public interface JobMapper {

    JobResponseDTO toJobResponse(Job job);
    Job toJob(JobResponseDTO jobResponseDTO);

}
