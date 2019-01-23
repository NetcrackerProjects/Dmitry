package ru.titov.taskmanagerserver;

import ru.titov.taskmanagerserver.api.controller.Bootstrap;
import ru.titov.taskmanagerserver.api.repository.ProjectRepository;
import ru.titov.taskmanagerserver.api.repository.TaskRepository;
import ru.titov.taskmanagerserver.api.repository.UserRepository;
import ru.titov.taskmanagerserver.api.service.ProjectService;
import ru.titov.taskmanagerserver.api.service.TaskService;
import ru.titov.taskmanagerserver.api.service.UserService;
import ru.titov.taskmanagerserver.controller.BootstrapImpl;
import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.repository.ProjectRepositoryImpl;
import ru.titov.taskmanagerserver.repository.TaskRepositoryImpl;
import ru.titov.taskmanagerserver.repository.UserRepositoryImpl;
import ru.titov.taskmanagerserver.service.ProjectServiceImpl;
import ru.titov.taskmanagerserver.service.TaskServiceImpl;
import ru.titov.taskmanagerserver.service.UserServiceImpl;

public class App {

    public static void main(String[] args) {
        final ProjectRepository projectRepository = new ProjectRepositoryImpl();
        final ProjectService projectService = new ProjectServiceImpl(projectRepository);
        final TaskRepository taskRepository = new TaskRepositoryImpl();
        final TaskService taskService = new TaskServiceImpl(taskRepository);
        final UserRepository userRepository = new UserRepositoryImpl();
        final UserService userService = new UserServiceImpl(userRepository);
        final Bootstrap bootstrap = new BootstrapImpl(projectService, taskService, userService);
        bootstrap.run();
    }
}
