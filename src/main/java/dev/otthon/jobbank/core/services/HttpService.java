package dev.otthon.jobbank.core.services;

import java.util.Optional;

public interface HttpService {

    <T>Optional<T> getPathVariable(String name, Class<T> type);

}
