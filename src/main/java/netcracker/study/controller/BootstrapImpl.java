package netcracker.study.controller;

import lombok.Getter;
import lombok.Setter;
import netcracker.study.api.controller.Bootstrap;
import netcracker.study.api.repository.ProjectRepository;
import netcracker.study.api.repository.TaskRepository;
import netcracker.study.api.service.ProjectService;
import netcracker.study.api.service.TaskService;
import netcracker.study.command.AbstractCommand;
import netcracker.study.error.NoSuchCommandsException;
import netcracker.study.repository.ProjectRepositoryImpl;
import netcracker.study.repository.TaskRepositoryImpl;
import netcracker.study.service.ProjectServiceImpl;
import netcracker.study.service.TaskServiceImpl;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

@Getter
@Setter
public class BootstrapImpl implements Bootstrap {

    private final ProjectRepository projectRepository = new ProjectRepositoryImpl();

    private final TaskRepository taskRepository = new TaskRepositoryImpl();

    private final ProjectService projectService = new ProjectServiceImpl(projectRepository);

    private final TaskService taskService = new TaskServiceImpl(taskRepository);

    private final Scanner scanner = new Scanner(System.in);

    private final Reflections reflections = new Reflections("netcracker.study.command");

    private final Set<Class<? extends AbstractCommand>> commandClasses = reflections.getSubTypesOf(AbstractCommand.class);

    private final Map<String, AbstractCommand> commandsMapping = new HashMap<>();

    @Override
    public void start() {
        try {
            initCommands();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("PROJECT MANAGER");
        while (scanner.hasNext()) {
            final String userCommand = scanner.nextLine().toLowerCase().trim();
            if ("exit".equals(userCommand)) {
                break;
            }
            if (commandsMapping.containsKey(userCommand)) {
                try {
                    commandsMapping.get(userCommand).execute();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private void initCommands() throws IllegalAccessException, InstantiationException, NoSuchCommandsException {
        if (commandClasses.isEmpty()) {
            throw new NoSuchCommandsException("No commands");
        }
        for (final Class<? extends AbstractCommand> commandClass : commandClasses) {
            final AbstractCommand command = commandClass.newInstance();
            command.setBootstrap(this);
            commandsMapping.put(command.command(), command);
        }
    }
    
}
