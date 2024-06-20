package dev.otthon.jobbank.core.exceptions;

public class SkillNotFoundException extends ModelNotFoundException{

    public SkillNotFoundException() {
        super("Skill not found | Habilidade não encontrada");
    }

    public SkillNotFoundException(String message) {
        super(message);
    }
}
