package ru.titov.taskmanagerclient.controller;

import lombok.Getter;
import lombok.Setter;
import ru.titov.taskmanagerclient.api.controller.Bootstrap;
import ru.titov.taskmanagerclient.command.AbstractCommand;
import ru.titov.taskmanagerclient.command.help.HelpCommand;
import ru.titov.taskmanagerclient.command.project.*;
import ru.titov.taskmanagerclient.command.task.*;
import ru.titov.taskmanagerclient.command.user.UserChangePasswordCommand;
import ru.titov.taskmanagerclient.command.user.UserSignInCommand;
import ru.titov.taskmanagerclient.command.user.UserSignUpCommand;
import ru.titov.taskmanagerclient.command.user.UserViewAllCommand;
import ru.titov.taskmanagerclient.error.command.NoSuchCommandsException;
import ru.titov.taskmanagerclient.util.ScannerUtil;
import ru.titov.taskmanagerserver.endpoint.project.ProjectEndpoint;
import ru.titov.taskmanagerserver.endpoint.task.TaskEndpoint;
import ru.titov.taskmanagerserver.endpoint.user.UserEndpoint;

import java.util.*;

@Getter
@Setter
public class BootstrapImpl implements Bootstrap {

    private final UserEndpoint userEndpoint;

    private final TaskEndpoint taskEndpoint;

    private final ProjectEndpoint projectEndpoint;

    private final Map<String, AbstractCommand> commandsMapping = new LinkedHashMap<>();

    private final Set<Class<? extends AbstractCommand>> commandClasses = new LinkedHashSet<>(Arrays.asList(
            HelpCommand.class, ProjectCreateCommand.class, ProjectRemoveCommand.class, ProjectUpdateCommand.class,
            ProjectViewCommand.class, ProjectViewAllCommand.class, TaskCreateCommand.class, TaskRemoveCommand.class,
            TaskUpdateCommand.class, TaskViewCommand.class, TaskViewAllCommand.class, UserSignInCommand.class,
            UserSignUpCommand.class, UserChangePasswordCommand.class, UserViewAllCommand.class
    ));

    public BootstrapImpl(UserEndpoint userEndpoint, TaskEndpoint taskEndpoint, ProjectEndpoint projectEndpoint) {
        this.userEndpoint = userEndpoint;
        this.taskEndpoint = taskEndpoint;
        this.projectEndpoint = projectEndpoint;
    }

    @Override
    public void start() {
        try {
            initCommands();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("[TASK MANAGER]");
        while (ScannerUtil.getScanner().hasNext()) {
            final String userCommand = ScannerUtil.nextLine();
            if ("exit".equals(userCommand)) break;
            if (commandsMapping.containsKey(userCommand)) {
                final AbstractCommand command = commandsMapping.get(userCommand);
                command.execute();
            }
        }
    }

    private void initCommands() throws IllegalAccessException, InstantiationException, NoSuchCommandsException {
        if (commandClasses.isEmpty()) throw new NoSuchCommandsException();
        for (final Class<? extends AbstractCommand> commandClass : commandClasses) {
            final AbstractCommand command = commandClass.newInstance();
            command.setBootstrap(this);
            commandsMapping.put(command.command(), command);
        }
    }

}
