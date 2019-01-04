package netcracker.study.repository;

import lombok.Getter;
import netcracker.study.api.repository.TaskRepository;
import netcracker.study.entity.Task;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
public class TaskRepositoryImpl implements TaskRepository {

    private final Map<String, Task> tasksMap = new LinkedHashMap<>();

    @Override
    public Task addTask(final Task task) {
        final String taskId = task.getId();
        tasksMap.put(taskId, task);
        return task;
    }

    @Override
    public Task getTaskByOrderIndex(final int taskOrderIndex) {
        final List<Task> tasks = getTasks();
        return tasks.get(taskOrderIndex);
    }

    @Override
    public Task getTaskById(String taskId) {
        return tasksMap.get(taskId);
    }

    @Override
    public Task updateTask(final Task task) {
        tasksMap.put(task.getId(), task);
        return task;
    }

    @Override
    public Task deleteTaskByOrderIndex(final int taskOrderIndex) {
        final Task task = getTaskByOrderIndex(taskOrderIndex);
        return deleteTaskById(task.getId());
    }

    @Override
    public Task deleteTaskById(final String taskId) {
        return tasksMap.remove(taskId);
    }

    @Override
    public boolean isTaskCreated(String taskId) {
        return tasksMap.containsKey(taskId);
    }

    @Override
    public List<Task> getTasks() {
        return new ArrayList<>(tasksMap.values());
    }

}
