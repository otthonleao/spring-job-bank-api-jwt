package dev.otthon.jobbank.core.repositories;

import dev.otthon.jobbank.core.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
