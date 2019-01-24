package ru.titov.taskmanagerclient.controller;

import lombok.Getter;
import lombok.Setter;
import ru.titov.taskmanagerclient.api.controller.Bootstrap;
import ru.titov.taskmanagerclient.api.controller.CommandLocator;
import ru.titov.taskmanagerclient.api.controller.EndpointLocator;
import ru.titov.taskmanagerclient.command.AbstractCommand;
import ru.titov.taskmanagerclient.command.help.HelpCommand;
import ru.titov.taskmanagerclient.command.project.ProjectCreateCommand;
import ru.titov.taskmanagerclient.command.project.ProjectRemoveCommand;
import ru.titov.taskmanagerclient.command.project.ProjectUpdateCommand;
import ru.titov.taskmanagerclient.command.project.ProjectViewAllCommand;
import ru.titov.taskmanagerclient.command.project.ProjectViewCommand;
import ru.titov.taskmanagerclient.command.task.TaskCreateCommand;
import ru.titov.taskmanagerclient.command.task.TaskRemoveCommand;
import ru.titov.taskmanagerclient.command.task.TaskUpdateCommand;
import ru.titov.taskmanagerclient.command.task.TaskViewAllCommand;
import ru.titov.taskmanagerclient.command.task.TaskViewCommand;
import ru.titov.taskmanagerclient.command.user.UserChangePasswordCommand;
import ru.titov.taskmanagerclient.command.user.UserSignInCommand;
import ru.titov.taskmanagerclient.command.user.UserSignUpCommand;
import ru.titov.taskmanagerclient.command.user.UserViewAllCommand;
import ru.titov.taskmanagerclient.error.command.NoSuchCommandsException;
import ru.titov.taskmanagerclient.util.ScannerUtil;
import ru.titov.taskmanagerserver.endpoint.project.ProjectEndpoint;
import ru.titov.taskmanagerserver.endpoint.project.ProjectEndpointService;
import ru.titov.taskmanagerserver.endpoint.task.TaskEndpoint;
import ru.titov.taskmanagerserver.endpoint.task.TaskEndpointService;
import ru.titov.taskmanagerserver.endpoint.user.UserEndpoint;
import ru.titov.taskmanagerserver.endpoint.user.UserEndpointService;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
public class BootstrapImpl implements Bootstrap, EndpointLocator, CommandLocator {

    private final UserEndpoint userEndpoint;

    private final TaskEndpoint taskEndpoint;

    private final ProjectEndpoint projectEndpoint;

    private final Map<String, AbstractCommand> commandsMapping;

    private final Set<Class<? extends AbstractCommand>> commandClasses;

    public BootstrapImpl() {
        userEndpoint = new UserEndpointService().getUserEndpointPort();
        taskEndpoint = new TaskEndpointService().getTaskEndpointPort();
        projectEndpoint = new ProjectEndpointService().getProjectEndpointPort();
        commandsMapping = new LinkedHashMap<>();
        commandClasses = new LinkedHashSet<>(Arrays.asList(
                HelpCommand.class, ProjectCreateCommand.class, ProjectRemoveCommand.class, ProjectUpdateCommand.class,
                ProjectViewCommand.class, ProjectViewAllCommand.class, TaskCreateCommand.class, TaskRemoveCommand.class,
                TaskUpdateCommand.class, TaskViewCommand.class, TaskViewAllCommand.class, UserSignInCommand.class,
                UserSignUpCommand.class, UserChangePasswordCommand.class, UserViewAllCommand.class
        ));
        try {
            initCommands();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start() {
        System.out.println("[TASK MANAGER]");
        while (ScannerUtil.getScanner().hasNext()) {
            final String userCommand = ScannerUtil.nextLine();
            if ("exit".equals(userCommand)) return;
            if (commandsMapping.containsKey(userCommand)) {
                final AbstractCommand command = commandsMapping.get(userCommand);
                command.execute();
            }
        }
    }

    private void initCommands() throws IllegalAccessException, InstantiationException {
        if (commandClasses.isEmpty()) throw new NoSuchCommandsException();
        for (final Class<? extends AbstractCommand> commandClass : commandClasses) {
            final AbstractCommand command = commandClass.newInstance();
            command.setEndpointLocator(this);
            command.setCommandLocator(this);
            commandsMapping.put(command.command(), command);
        }
    }

}
