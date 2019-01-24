package ru.titov.taskmanagerserver.api.service;

import ru.titov.taskmanagerserver.entity.User;

import java.util.List;

public interface UserService {

    void signUp(String login, String passwordHash);

    String signIn(String login, String passwordHash);

    void init();

    void add(User user);

    User getByLogin(String login);

    User getById(String id);

    void changePassword(String token, String newPasswordHash);

    void removeByLogin(String login);

    void removeById(String id);

    boolean doesExistsById(String id);

    boolean doesExistsByLogin(String login);

    List<User> getAll();

}
