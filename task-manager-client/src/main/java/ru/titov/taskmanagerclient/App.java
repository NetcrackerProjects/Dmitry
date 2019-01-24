package ru.titov.taskmanagerclient;

import ru.titov.taskmanagerclient.api.controller.Bootstrap;
import ru.titov.taskmanagerclient.controller.BootstrapImpl;
import ru.titov.taskmanagerserver.endpoint.project.ProjectEndpoint;
import ru.titov.taskmanagerserver.endpoint.project.ProjectEndpointService;
import ru.titov.taskmanagerserver.endpoint.task.TaskEndpoint;
import ru.titov.taskmanagerserver.endpoint.task.TaskEndpointService;
import ru.titov.taskmanagerserver.endpoint.user.UserEndpoint;
import ru.titov.taskmanagerserver.endpoint.user.UserEndpointService;

public class App {

    public static void main(String[] args) {
        final Bootstrap bootstrap = new BootstrapImpl();
        bootstrap.start();
    }

}
