package netcracker.study.service;

import netcracker.study.api.repository.ProjectRepository;
import netcracker.study.api.service.ProjectService;
import netcracker.study.entity.Project;
import netcracker.study.error.InvalidInputException;
import netcracker.study.error.ProjectErrorMessage;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project addProject(final Project project) throws InvalidInputException {
        if (project == null) {
            throw new InvalidInputException(ProjectErrorMessage.INVALID_PROJECT_INPUT);
        }
        return projectRepository.addProject(project);
    }

    @Override
    public Project getProjectByOrderIndex(final Integer projectOrderIndex) throws InvalidInputException {
        if (projectOrderIndex == null) {
            throw new InvalidInputException(ProjectErrorMessage.INVALID_PROJECT_ORDER_INDEX);
        }
        try {
            return projectRepository.getProjectByOrderIndex(projectOrderIndex);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidInputException(ProjectErrorMessage.INVALID_PROJECT_ORDER_INDEX);
        }
    }

    @Override
    public Project getProjectById(final String projectId) throws InvalidInputException {
        if (projectId == null) {
            throw new InvalidInputException(ProjectErrorMessage.INVALID_PROJECT_ORDER_INDEX);
        }
        try {
            return projectRepository.getProjectById(projectId);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidInputException(ProjectErrorMessage.INVALID_PROJECT_ORDER_INDEX);
        }
    }

    public Project updateProject(final Project project) throws InvalidInputException {
        if (project == null || !projectRepository.isProjectCreated(project.getId())) {
            throw new InvalidInputException(ProjectErrorMessage.INVALID_PROJECT_INPUT);
        }
        return projectRepository.updateProject(project);
    }

    @Override
    public Project deleteProjectByOrderIndex(Integer projectOrderIndex) throws InvalidInputException {
        if (projectOrderIndex == null) {
            throw new InvalidInputException(ProjectErrorMessage.INVALID_PROJECT_ORDER_INDEX);
        }
        try {
            return projectRepository.deleteProjectByOrderIndex(projectOrderIndex);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidInputException(ProjectErrorMessage.INVALID_PROJECT_ORDER_INDEX);
        }
    }

    @Override
    public Project deleteProjectById(String projectId) throws InvalidInputException {
        if (projectId == null || !projectRepository.isProjectCreated(projectId)) {
            throw new InvalidInputException(ProjectErrorMessage.INVALID_PROJECT_ID);
        }
        return projectRepository.deleteProjectById(projectId);
    }

    @Override
    public List<Project> getProjects() {
        return projectRepository.getProjects();
    }

}
