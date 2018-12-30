package netcracker.study.api.service;

import netcracker.study.entity.Task;
import netcracker.study.error.InvalidInputException;

import java.util.List;

public interface ITaskService {

    Task addTask(Task task) throws InvalidInputException;

    Task getTaskByOrderIndex(Integer taskOrderIndex) throws InvalidInputException;

    Task getTaskById(String taskId) throws InvalidInputException;

    Task updateTask(Task task) throws InvalidInputException;

    Task deleteTaskByOrderIndex(Integer taskOrderIndex) throws InvalidInputException;

    Task deleteTaskById(String taskId) throws InvalidInputException;

    List<Task> getTasks();

}
