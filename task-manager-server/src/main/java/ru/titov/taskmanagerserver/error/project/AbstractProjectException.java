package ru.titov.taskmanagerserver.error.project;

public abstract class AbstractProjectException extends RuntimeException {

    public AbstractProjectException(String message) {
        super(message);
    }
}
