package netcracker.study.command;

import netcracker.study.entity.Project;
import netcracker.study.error.InvalidInputException;

public class ProjectViewCommand extends AbstractCommand {

    @Override
    public void execute() throws InvalidInputException {
        System.out.println("Enter order index:");
        final Integer orderId = bootstrap.nextInt();
        final Project project = bootstrap.getProjectService().getProjectByOrderIndex(orderId);
        System.out.println(orderId + " " + project);
    }

    @Override
    public String command() {
        return "view_project";
    }

    @Override
    public String description() {
        return "view project by order index";
    }
}
