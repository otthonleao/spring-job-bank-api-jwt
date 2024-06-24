package dev.otthon.jobbank.config;

import dev.otthon.jobbank.api.jobs.dtos.JobRequestDTO;
import dev.otthon.jobbank.core.models.Job;
import dev.otthon.jobbank.core.models.Skill;
import dev.otthon.jobbank.core.repositories.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/* ESSA CONFIGURAÇÃO SERVE PARA FAZER A INJEÇÃO DE DEPENDÊNCIA DO MODEL MAPPER */
@Configuration
@RequiredArgsConstructor
public class ModelMapperConfig {

    private final SkillRepository skillRepository;

    @Bean
    ModelMapper modelMapper() {
        var modelmapper = new ModelMapper();

        modelmapper.createTypeMap(JobRequestDTO.class, Job.class)
                .addMappings(mapper -> mapper
                        .using(toListOfSkills())
                        .map(JobRequestDTO::getSkills, Job::setSkills)
                );

        return modelmapper;
    }

    private Converter<List<Long>, List<Skill>> toListOfSkills() {
        return context -> skillRepository.findAllById(context.getSource());
    }

}
