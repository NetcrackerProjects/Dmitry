package ru.titov.taskmanagerserver.error.task;

public abstract class AbstractTaskException extends RuntimeException {

    public AbstractTaskException(String message) {
        super(message);
    }
}
