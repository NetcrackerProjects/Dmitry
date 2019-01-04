package netcracker.study.repository;

import netcracker.study.api.repository.TaskRepository;
import netcracker.study.entity.Task;
import org.junit.Assert;
import org.junit.Test;

public class TaskRepositoryTest {

    @Test
    public void testAddTaskPositive() {
        TaskRepository taskRepository = new TaskRepositoryImpl();
        Task task = new Task();

        taskRepository.addTask(task);

        Assert.assertTrue(taskRepository.getTasksMap().containsKey(task.getId()));
    }

    @Test(expected = NullPointerException.class)
    public void testAddTaskNegative() {
        TaskRepository TaskRepository = new TaskRepositoryImpl();

        TaskRepository.addTask(null);
    }

    @Test
    public void testUpdateTaskPositive() {
        String updatedName = "updated task name";
        TaskRepository taskRepository = new TaskRepositoryImpl();
        Task task = new Task();

        taskRepository.addTask(task);
        Task createdTask = taskRepository.getTaskByOrderIndex(0);
        createdTask.setName(updatedName);
        taskRepository.updateTask(createdTask);
        String updatedTaskName = taskRepository.getTasksMap().get(createdTask.getId()).getName();

        Assert.assertEquals(updatedName, updatedTaskName);
    }

    @Test(expected = NullPointerException.class)
    public void testUpdateTaskNegative() {
        TaskRepository TaskRepository = new TaskRepositoryImpl();

        TaskRepository.updateTask(null);
    }

    @Test
    public void testDeleteTaskByIdPositive() {
        TaskRepository taskRepository = new TaskRepositoryImpl();
        Task task = new Task();

        taskRepository.addTask(task);
        taskRepository.deleteTaskByOrderIndex(0);

        Assert.assertTrue(taskRepository.getTasksMap().isEmpty());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteTaskByIdNegative() {
        TaskRepository TaskRepository = new TaskRepositoryImpl();

        TaskRepository.deleteTaskByOrderIndex(0);
    }
}