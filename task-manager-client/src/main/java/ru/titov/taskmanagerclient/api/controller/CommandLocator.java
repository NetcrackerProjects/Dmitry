package ru.titov.taskmanagerclient.api.controller;

import ru.titov.taskmanagerclient.command.AbstractCommand;

import java.util.Map;

public interface CommandLocator {

    Map<String, AbstractCommand> getCommandsMapping();

}
