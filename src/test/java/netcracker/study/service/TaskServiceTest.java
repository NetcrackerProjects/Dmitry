package netcracker.study.service;

import netcracker.study.api.repository.TaskRepository;
import netcracker.study.entity.Task;
import netcracker.study.error.InvalidInputException;
import netcracker.study.repository.TaskRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TaskServiceTest {

    @Test
    public void testAddTaskPositive() throws InvalidInputException {
        String taskName = "created task";
        TaskRepository TaskRepository = new TaskRepositoryImpl();
        TaskServiceImpl taskService = new TaskServiceImpl(TaskRepository);
        Task task = new Task();

        task.setName(taskName);
        taskService.addTask(task);
        Task createdTask = taskService.getTaskByOrderIndex(0);

        Assert.assertEquals(taskName, createdTask.getName());
    }

    @Test(expected = InvalidInputException.class)
    public void testAddTaskNegative() throws InvalidInputException {
        TaskRepository TaskRepository = new TaskRepositoryImpl();
        TaskServiceImpl taskService = new TaskServiceImpl(TaskRepository);

        taskService.addTask(null);
    }

    @Test
    public void testUpdateTaskPositive() throws InvalidInputException {
        String updatedName = "updated task name";
        TaskRepository TaskRepository = new TaskRepositoryImpl();
        TaskServiceImpl taskService = new TaskServiceImpl(TaskRepository);
        Task task = new Task();

        taskService.addTask(task);
        Task createdTask = taskService.getTaskByOrderIndex(0);
        createdTask.setName(updatedName);
        taskService.updateTask(task);
        Task updatedTask = taskService.getTaskByOrderIndex(0);

        Assert.assertEquals(updatedName, updatedTask.getName());
    }

    @Test(expected = InvalidInputException.class)
    public void testUpdateTaskNegative() throws InvalidInputException {
        TaskRepository TaskRepository = new TaskRepositoryImpl();
        TaskServiceImpl taskService = new TaskServiceImpl(TaskRepository);

        taskService.updateTask(null);
    }

    @Test
    public void testDeleteTaskPositive() throws InvalidInputException {
        TaskRepository TaskRepository = new TaskRepositoryImpl();
        TaskServiceImpl taskService = new TaskServiceImpl(TaskRepository);
        Task task = new Task();

        taskService.addTask(task);
        taskService.deleteTaskByOrderIndex(0);
        List<Task> projects = taskService.getTasks();

        Assert.assertTrue(projects.isEmpty());
    }

    @Test(expected = InvalidInputException.class)
    public void testDeleteTaskNegative() throws InvalidInputException {
        TaskRepository TaskRepository = new TaskRepositoryImpl();
        TaskServiceImpl taskService = new TaskServiceImpl(TaskRepository);

        taskService.deleteTaskByOrderIndex(0);
    }
}