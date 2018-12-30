package netcracker.study.command;

import netcracker.study.entity.Task;
import netcracker.study.error.InvalidInputException;

public class TaskViewCommand extends AbstractCommand {

    @Override
    public void execute() throws InvalidInputException {
        System.out.println("Enter order index:");
        final Integer orderId = bootstrap.nextInt();
        final Task task = bootstrap.getTaskService().getTaskByOrderIndex(orderId);
        System.out.println(orderId + " " + task);
    }

    @Override
    public String command() {
        return "view_task";
    }

    @Override
    public String description() {
        return "view task by order index";
    }
}
