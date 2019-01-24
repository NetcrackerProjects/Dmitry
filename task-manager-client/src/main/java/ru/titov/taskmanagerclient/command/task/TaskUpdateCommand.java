package ru.titov.taskmanagerclient.command.task;

import ru.titov.taskmanagerclient.command.AbstractCommand;
import ru.titov.taskmanagerclient.util.ScannerUtil;
import ru.titov.taskmanagerserver.endpoint.task.Response;

public class TaskUpdateCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println("[UPDATE TASK]");
        System.out.println("Enter token:");
        final String token = ScannerUtil.nextLine();
        System.out.println("Enter task order index:");
        final Integer taskOrderIndex = ScannerUtil.nextInt();
        System.out.println("Enter new project order index:");
        final Integer projectOrderIndex = ScannerUtil.nextInt();
        System.out.println("Enter new task name:");
        final String taskName = ScannerUtil.nextLine();
        System.out.println("Enter new task description:");
        final String taskDescription = ScannerUtil.nextLine();
        final Response response = endpointLocator.getTaskEndpoint().update(
                token,
                taskOrderIndex,
                projectOrderIndex,
                taskName,
                taskDescription
        );
        System.out.println(response.getMessage());
    }

    @Override
    public String command() {
        return "task-update";
    }

    @Override
    public String description() {
        return "update task by order index";
    }
}
