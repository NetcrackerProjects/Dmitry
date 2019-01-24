package ru.titov.taskmanagerclient.command.user;

import ru.titov.taskmanagerclient.command.AbstractCommand;
import ru.titov.taskmanagerclient.util.ScannerUtil;
import ru.titov.taskmanagerserver.endpoint.user.SimpleUser;
import ru.titov.taskmanagerserver.endpoint.user.UserListResponse;

import java.util.Collection;

public class UserViewAllCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println("[VIEW USERS]");
        System.out.println("Enter token:");
        final String token = ScannerUtil.nextLine();
        final UserListResponse userListResponse = endpointLocator.getUserEndpoint().viewAll(token);
        if (userListResponse.isSuccess()) {
            final Collection<SimpleUser> users = userListResponse.getUsers();
            if (users.isEmpty()) System.out.println("Users not found");
            int orderId = 1;
            for (final SimpleUser user : users) {
                System.out.println(orderId + ". " + user.getLogin());
                orderId++;
            }
        }
        System.out.println(userListResponse.getMessage());
    }

    @Override
    public String command() {
        return "user-view-all";
    }

    @Override
    public String description() {
        return "view all users";
    }
}
