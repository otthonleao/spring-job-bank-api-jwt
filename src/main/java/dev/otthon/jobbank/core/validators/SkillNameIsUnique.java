package dev.otthon.jobbank.core.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { SkillNameIsUniqueValidator.class })
public @interface SkillNameIsUnique {

    String message() default "This ${validatedValue} skill name is already in use | Este ${validatedValue} nome de habilidade já está em uso}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
