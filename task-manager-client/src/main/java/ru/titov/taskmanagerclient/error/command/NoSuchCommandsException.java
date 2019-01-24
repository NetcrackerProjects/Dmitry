package ru.titov.taskmanagerclient.error.command;

public class NoSuchCommandsException extends RuntimeException {

    public NoSuchCommandsException() {
        super("No commands");
    }

}
