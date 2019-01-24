package ru.titov.taskmanagerclient.command;

import lombok.Getter;
import lombok.Setter;
import ru.titov.taskmanagerclient.api.controller.CommandLocator;
import ru.titov.taskmanagerclient.api.controller.EndpointLocator;

@Getter
@Setter
public abstract class AbstractCommand {

    protected EndpointLocator endpointLocator;

    protected CommandLocator commandLocator;

    public abstract void execute();

    public abstract String command();

    public abstract String description();

}
