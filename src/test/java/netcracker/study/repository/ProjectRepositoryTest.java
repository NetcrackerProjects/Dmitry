package netcracker.study.repository;

import netcracker.study.api.repository.IProjectRepository;
import netcracker.study.entity.Project;
import org.junit.Assert;
import org.junit.Test;

public class ProjectRepositoryTest {

    @Test
    public void testAddProjectPositive() {
        final ProjectRepository projectRepository = new ProjectRepository();
        final Project project = new Project();
        projectRepository.addProject(project);
        Assert.assertTrue(projectRepository.getProjectsMap().containsKey(project.getId()));
    }

    @Test(expected = NullPointerException.class)
    public void testAddProjectNegative() {
        final IProjectRepository IProjectRepository = new ProjectRepository();
        IProjectRepository.addProject(null);
    }

    @Test
    public void testUpdateProjectPositive() {
        final String updatedName = "updated project name";
        final ProjectRepository projectRepository = new ProjectRepository();
        final Project project = new Project();
        projectRepository.addProject(project);
        final Project createdProject = projectRepository.getProjectByOrderIndex(0);
        createdProject.setName(updatedName);
        projectRepository.updateProject(createdProject);
        final String updatedProjectName = projectRepository.getProjectsMap().get(createdProject.getId()).getName();
        Assert.assertEquals(updatedName, updatedProjectName);
    }

    @Test(expected = NullPointerException.class)
    public void testUpdateProjectNegative() {
        final IProjectRepository IProjectRepository = new ProjectRepository();
        IProjectRepository.updateProject(null);
    }

    @Test
    public void testDeleteProjectByIdPositive() {
        final ProjectRepository projectRepository = new ProjectRepository();
        final Project project = new Project();
        projectRepository.addProject(project);
        projectRepository.deleteProjectByOrderIndex(0);
        Assert.assertTrue(projectRepository.getProjectsMap().isEmpty());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteProjectByIdNegative() {
        final IProjectRepository IProjectRepository = new ProjectRepository();
        IProjectRepository.deleteProjectByOrderIndex(0);
    }
}