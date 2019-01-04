package netcracker.study.service;

import netcracker.study.api.repository.ProjectRepository;
import netcracker.study.api.service.ProjectService;
import netcracker.study.entity.Project;
import netcracker.study.error.InvalidInputException;
import netcracker.study.repository.ProjectRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ProjectServiceTest {

    @Test
    public void testAddProjectPositive() throws InvalidInputException {
        String projectName = "created project";
        ProjectRepository ProjectRepository = new ProjectRepositoryImpl();
        ProjectService projectService = new ProjectServiceImpl(ProjectRepository);
        Project project = new Project();

        project.setName(projectName);
        projectService.addProject(project);
        Project createdProject = projectService.getProjectByOrderIndex(0);

        Assert.assertEquals(projectName, createdProject.getName());
    }

    @Test(expected = InvalidInputException.class)
    public void testAddProjectNegative() throws InvalidInputException {
        ProjectRepository ProjectRepository = new ProjectRepositoryImpl();
        ProjectService projectService = new ProjectServiceImpl(ProjectRepository);

        projectService.addProject(null);
    }

    @Test
    public void testUpdateProjectPositive() throws InvalidInputException {
        String updatedName = "updated project name";
        ProjectRepository ProjectRepository = new ProjectRepositoryImpl();
        ProjectServiceImpl projectService = new ProjectServiceImpl(ProjectRepository);
        Project project = new Project();

        projectService.addProject(project);
        Project createdProject = projectService.getProjectByOrderIndex(0);
        createdProject.setName(updatedName);
        projectService.updateProject(project);
        Project updatedProject = projectService.getProjectByOrderIndex(0);

        Assert.assertEquals(updatedName, updatedProject.getName());
    }

    @Test(expected = InvalidInputException.class)
    public void testUpdateProjectNegative() throws InvalidInputException {
        ProjectRepository ProjectRepository = new ProjectRepositoryImpl();
        ProjectServiceImpl projectService = new ProjectServiceImpl(ProjectRepository);

        projectService.updateProject(null);
    }

    @Test
    public void testDeleteProjectPositive() throws InvalidInputException {
        ProjectRepository ProjectRepository = new ProjectRepositoryImpl();
        ProjectServiceImpl projectService = new ProjectServiceImpl(ProjectRepository);
        Project project = new Project();

        projectService.addProject(project);
        projectService.deleteProjectByOrderIndex(0);
        List<Project> projects = projectService.getProjects();

        Assert.assertTrue(projects.isEmpty());
    }

    @Test(expected = InvalidInputException.class)
    public void testDeleteProjectNegative() throws InvalidInputException {
        ProjectRepository ProjectRepository = new ProjectRepositoryImpl();
        ProjectServiceImpl projectService = new ProjectServiceImpl(ProjectRepository);

        projectService.deleteProjectByOrderIndex(0);
    }

}