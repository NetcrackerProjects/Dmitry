package ru.titov.taskmanagerserver.api.service;

import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.error.project.AbstractProjectException;
import ru.titov.taskmanagerserver.error.project.InvalidProjectIdException;
import ru.titov.taskmanagerserver.error.user.AbstractUserException;

import java.util.List;

public interface ProjectService {

    void add(Project project);

    Project getByOrderIndex(String userId, Integer projectOrderIndex);

    Project getById(String projectId);

    void update(Project project);

    void removeByOrderIndex(String userId, Integer projectOrderIndex);

    void removeById(String projectId);

    boolean doesExists(String projectId);

    List getAll();

    List<Project> getAllByUserId(String userId);
}
