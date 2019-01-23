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
        final UserEndpoint userEndpoint = new UserEndpointService().getUserEndpointPort();
        final TaskEndpoint taskEndpoint = new TaskEndpointService().getTaskEndpointPort();
        final ProjectEndpoint projectEndpoint = new ProjectEndpointService().getProjectEndpointPort();
        final Bootstrap bootstrap = new BootstrapImpl(userEndpoint, taskEndpoint, projectEndpoint);
        bootstrap.start();
    }

}
