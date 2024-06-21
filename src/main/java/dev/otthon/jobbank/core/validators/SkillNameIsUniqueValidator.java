package dev.otthon.jobbank.core.validators;

import dev.otthon.jobbank.core.repositories.SkillRepository;
import dev.otthon.jobbank.core.services.HttpService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SkillNameIsUniqueValidator implements ConstraintValidator<SkillNameIsUnique, String> {

    private final SkillRepository skillRepository;
    private final HttpService httpService;

    @Override
    public void initialize(SkillNameIsUnique constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        if(value == null) return true;

        var id = httpService.getPathVariable("id", Long.class);

        if (id.isEmpty()) {
            return !skillRepository.existsByName(value);
        }

        return !skillRepository.existsByNameAndIdNot(value, id.get());
    }
}
