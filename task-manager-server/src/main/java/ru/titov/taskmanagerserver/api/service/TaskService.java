package ru.titov.taskmanagerserver.api.service;

import ru.titov.taskmanagerserver.entity.Task;

import java.util.List;

public interface TaskService {

    void add(Task task);

    Task getByOrderIndex(String userId, Integer taskOrderIndex);

    Task getById(String taskId);

    void update(Task task);

    void removeByOrderIndex(String userId, Integer taskOrderIndex);

    void removeById(String taskId);

    boolean doesExists(String taskId);

    List<Task> getAll();

    List<Task> getAllByUserId(String userId);

    List<Task> getAllByProjectId(String projectId);
}
