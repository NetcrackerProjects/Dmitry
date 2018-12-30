package netcracker.study.controller;

import lombok.Getter;
import lombok.Setter;
import netcracker.study.api.controller.IBootstrap;
import netcracker.study.api.repository.IProjectRepository;
import netcracker.study.api.repository.ITaskRepository;
import netcracker.study.api.service.IProjectService;
import netcracker.study.api.service.ITaskService;
import netcracker.study.command.AbstractCommand;
import netcracker.study.error.NoSuchCommandsException;
import netcracker.study.repository.ProjectRepository;
import netcracker.study.repository.TaskRepository;
import netcracker.study.service.ProjectService;
import netcracker.study.service.TaskService;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

@Getter
@Setter
public class Bootstrap implements IBootstrap {

    private final IProjectRepository projectRepository = new ProjectRepository();

    private final ITaskRepository taskRepository = new TaskRepository();

    private final IProjectService projectService = new ProjectService(projectRepository);

    private final ITaskService taskService = new TaskService(taskRepository);

    private final Scanner scanner = new Scanner(System.in);

    private final Reflections reflections = new Reflections("netcracker.study.command");

    private final Set<Class<? extends AbstractCommand>> commandClasses = reflections.getSubTypesOf(AbstractCommand.class);

    private final Map<String, AbstractCommand> commandsMapping = new HashMap<>();

    @Override
    public void start() {
        try { initCommands(); } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("PROJECT MANAGER");
        while (scanner.hasNext()) {
            final String userCommand = scanner.nextLine().toLowerCase().trim();
            if ("exit".equals(userCommand)) { break; }
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
        if (commandClasses.isEmpty()) { throw new NoSuchCommandsException("No commands"); }
        for (final Class<? extends AbstractCommand> commandClass : commandClasses) {
            final AbstractCommand command = commandClass.newInstance();
            command.setBootstrap(this);
            commandsMapping.put(command.command(), command);
        }
    }

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }

    @Override
    public Integer nextInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return null;
        }
    }
}
