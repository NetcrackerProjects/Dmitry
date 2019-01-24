package ru.titov.taskmanagerserver.error.user;

public abstract class AbstractUserException extends RuntimeException {

    public AbstractUserException(String message) {
        super(message);
    }
}
