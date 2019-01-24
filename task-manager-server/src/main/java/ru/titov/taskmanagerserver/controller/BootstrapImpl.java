package ru.titov.taskmanagerserver.controller;

import lombok.Getter;
import ru.titov.taskmanagerserver.api.controller.Bootstrap;
import ru.titov.taskmanagerserver.api.repository.ProjectRepository;
import ru.titov.taskmanagerserver.api.repository.TaskRepository;
import ru.titov.taskmanagerserver.api.repository.UserRepository;
import ru.titov.taskmanagerserver.api.service.ProjectService;
import ru.titov.taskmanagerserver.api.service.ServiceLocator;
import ru.titov.taskmanagerserver.api.service.TaskService;
import ru.titov.taskmanagerserver.api.service.UserService;
import ru.titov.taskmanagerserver.config.AppConfig;
import ru.titov.taskmanagerserver.endpoint.project.ProjectEndpoint;
import ru.titov.taskmanagerserver.endpoint.task.TaskEndpoint;
import ru.titov.taskmanagerserver.endpoint.user.UserEndpoint;
import ru.titov.taskmanagerserver.repository.ProjectRepositoryImpl;
import ru.titov.taskmanagerserver.repository.TaskRepositoryImpl;
import ru.titov.taskmanagerserver.repository.UserRepositoryImpl;
import ru.titov.taskmanagerserver.service.ProjectServiceImpl;
import ru.titov.taskmanagerserver.service.TaskServiceImpl;
import ru.titov.taskmanagerserver.service.UserServiceImpl;

import javax.xml.ws.Endpoint;

public class BootstrapImpl implements Bootstrap, ServiceLocator {

    @Getter
    private final ProjectService projectService;

    @Getter
    private final TaskService taskService;

    @Getter
    private final UserService userService;

    public BootstrapImpl() {
        final ProjectRepository projectRepository = new ProjectRepositoryImpl();
        projectService = new ProjectServiceImpl(projectRepository);
        final TaskRepository taskRepository = new TaskRepositoryImpl();
        taskService = new TaskServiceImpl(taskRepository);
        final UserRepository userRepository = new UserRepositoryImpl();
        userService = new UserServiceImpl(userRepository);
    }

    public void run() {
        try {
            userService.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        final StringBuilder endpointAddress = new StringBuilder();
        endpointAddress.append("http://");
        endpointAddress.append(AppConfig.SERVER_HOST);
        endpointAddress.append(":");
        endpointAddress.append(AppConfig.SERVER_PORT);
        endpointAddress.append("/");
        Endpoint.publish(endpointAddress.toString() + ("UserEndpoint?wsdl"), new UserEndpoint(this));
        Endpoint.publish(endpointAddress.toString() + ("TaskEndpoint?wsdl"), new TaskEndpoint(this));
        Endpoint.publish(endpointAddress.toString() + ("ProjectEndpoint?wsdl"), new ProjectEndpoint(this));
        System.out.println("[SERVER START]");
    }

}
