package netcracker.study.api.service;

import netcracker.study.entity.Project;
import netcracker.study.error.InvalidInputException;

import java.util.List;

public interface ProjectService {

    Project addProject(Project project) throws InvalidInputException;

    Project getProjectByOrderIndex(Integer projectOrderIndex) throws InvalidInputException;

    Project getProjectById(String projectId) throws InvalidInputException;

    Project updateProject(Project project) throws InvalidInputException;

    Project deleteProjectByOrderIndex(Integer projectOrderIndex) throws InvalidInputException;

    Project deleteProjectById(String projectId) throws InvalidInputException;

    List<Project> getProjects();

}
