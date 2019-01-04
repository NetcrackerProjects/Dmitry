package netcracker.study.api.repository;

import netcracker.study.entity.Task;

import java.util.List;
import java.util.Map;

public interface TaskRepository {

    Task addTask(Task task);

    Task getTaskByOrderIndex(int taskOrderIndex);

    Task getTaskById(String taskId);

    Task updateTask(Task task);

    Task deleteTaskByOrderIndex(int taskOrderIndex);

    Task deleteTaskById(String taskId);

    boolean isTaskCreated(String taskId);

    List<Task> getTasks();

    Map<String, Task> getTasksMap();
}
