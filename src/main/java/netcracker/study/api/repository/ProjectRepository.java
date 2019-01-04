package netcracker.study.api.repository;

import netcracker.study.entity.Project;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ProjectRepository {

    Project addProject(Project project);

    Project getProjectByOrderIndex(int projectOrderIndex);

    Project getProjectById(String projectId);

    Project updateProject(Project project);

    Project deleteProjectByOrderIndex(int projectOrderIndex);

    Project deleteProjectById(String projectId);

    boolean isProjectCreated(String projectId);

    List<Project> getProjects();

    Map<String, Project> getProjectsMap();
}
