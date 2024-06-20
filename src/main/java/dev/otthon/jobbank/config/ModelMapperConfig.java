package dev.otthon.jobbank.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* ESSA CONFIGURAÇÃO SERVE PARA FAZER A INJEÇÃO DE DEPENDÊNCIA DO MODEL MAPPER */
@Configuration
public class ModelMapperConfig {

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
