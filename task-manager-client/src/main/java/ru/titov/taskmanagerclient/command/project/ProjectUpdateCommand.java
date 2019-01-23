package ru.titov.taskmanagerclient.command.project;

import ru.titov.taskmanagerclient.command.AbstractCommand;
import ru.titov.taskmanagerclient.util.ScannerUtil;
import ru.titov.taskmanagerserver.endpoint.project.Response;

public class ProjectUpdateCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println("[UPDATE PROJECT]");
        System.out.println("Enter token:");
        final String token = ScannerUtil.nextLine();
        System.out.println("Enter order index:");
        final Integer orderId = ScannerUtil.nextInt();
        System.out.println("Enter new project name:");
        final String projectName = ScannerUtil.nextLine();
        final Response response = bootstrap.getProjectEndpoint().update(token, orderId, projectName);
        System.out.println(response.getMessage());
    }

    @Override
    public String command() {
        return "project-update";
    }

    @Override
    public String description() {
        return "update project by order index";
    }

}
