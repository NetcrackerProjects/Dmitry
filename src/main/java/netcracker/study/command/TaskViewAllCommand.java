package netcracker.study.command;

import netcracker.study.entity.Task;

import java.util.Collection;

public class TaskViewAllCommand extends AbstractCommand {

    @Override
    public void execute() {
        final Collection<Task> tasks = bootstrap.getTaskService().getTasks();
        int orderId = 0;
        if (tasks.isEmpty()) {
            System.out.println("Tasks not found");
        }
        for (final Task task : tasks) {
            System.out.println(orderId + " " + task);
            orderId++;
        }
    }

    @Override
    public String command() {
        return "view_tasks";
    }

    @Override
    public String description() {
        return "view all tasks in ToDoList";
    }
}
