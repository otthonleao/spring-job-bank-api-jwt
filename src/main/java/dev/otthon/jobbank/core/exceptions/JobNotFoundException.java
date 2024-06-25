package dev.otthon.jobbank.core.exceptions;

public class JobNotFoundException extends ModelNotFoundException{

    public JobNotFoundException(String message) {
        super(message);
    }

    public JobNotFoundException() {
        super("Job not found");
    }
}
