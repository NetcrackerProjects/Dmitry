package ru.titov.taskmanagerclient.command.user;

import ru.titov.taskmanagerclient.command.AbstractCommand;
import ru.titov.taskmanagerclient.util.ScannerUtil;
import ru.titov.taskmanagerserver.endpoint.user.Response;

public class UserSignUpCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println("[REGISTER USER]");
        System.out.println("Enter login:");
        final String login = ScannerUtil.nextLine();
        System.out.println("Enter password:");
        final String password = ScannerUtil.nextLine();
        final Response response = endpointLocator.getUserEndpoint().signUp(login, password);
        System.out.println(response.getMessage());
    }

    @Override
    public String command() {
        return "sign-up";
    }

    @Override
    public String description() {
        return "sign up user in TaskManager";
    }

}
