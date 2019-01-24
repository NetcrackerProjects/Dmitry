package ru.titov.taskmanagerclient.command.user;

import ru.titov.taskmanagerclient.command.AbstractCommand;
import ru.titov.taskmanagerclient.util.ScannerUtil;
import ru.titov.taskmanagerserver.endpoint.user.Response;

public class UserChangePasswordCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println("[CHANGE PASSWORD]");
        System.out.println("Enter token:");
        final String token = ScannerUtil.nextLine();
        System.out.println("Enter new password:");
        final String password = ScannerUtil.nextLine();
        final Response response = endpointLocator.getUserEndpoint().changePassword(token, password);
        System.out.println(response.getMessage());
    }

    @Override
    public String command() {
        return "password-change";
    }

    @Override
    public String description() {
        return "change user password in TaskManager";
    }
}
