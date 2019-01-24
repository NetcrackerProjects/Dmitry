package ru.titov.taskmanagerclient.api.controller;

import ru.titov.taskmanagerserver.endpoint.project.ProjectEndpoint;
import ru.titov.taskmanagerserver.endpoint.task.TaskEndpoint;
import ru.titov.taskmanagerserver.endpoint.user.UserEndpoint;

public interface EndpointLocator {

    UserEndpoint getUserEndpoint();

    TaskEndpoint getTaskEndpoint();

    ProjectEndpoint getProjectEndpoint();

}
