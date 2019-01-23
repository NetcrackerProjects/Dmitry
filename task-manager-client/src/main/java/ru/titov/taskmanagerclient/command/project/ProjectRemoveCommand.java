package ru.titov.taskmanagerclient.command.project;

import ru.titov.taskmanagerclient.command.AbstractCommand;
import ru.titov.taskmanagerclient.util.ScannerUtil;
import ru.titov.taskmanagerserver.endpoint.project.Response;

public class ProjectRemoveCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println("[REMOVE PROJECT]");
        System.out.println("Enter token");
        final String token = ScannerUtil.nextLine();
        System.out.println("Enter order index:");
        final Integer orderIndex = ScannerUtil.nextInt();
        final Response response = bootstrap.getProjectEndpoint().remove(token, orderIndex);
        System.out.println(response.getMessage());
    }

    @Override
    public String command() {
        return "project-remove";
    }

    @Override
    public String description() {
        return "remove project by order index";
    }

}
